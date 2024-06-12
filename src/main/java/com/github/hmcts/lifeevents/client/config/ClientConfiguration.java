package com.github.hmcts.lifeevents.client.config;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.security.KeyManagementException;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

import feign.Client;
import feign.RequestInterceptor;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.security.oauth2.client.http.OAuth2ErrorResponseErrorHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.http.converter.OAuth2AccessTokenResponseHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@EnableConfigurationProperties
public class ClientConfiguration {

  private static final Logger logger = LoggerFactory.getLogger(ClientConfiguration.class);

  private final ClientRegistrationRepository clientRegistrationRepository;

  @Value("${http.client.max.total}")
  private int maxTotalHttpClient;

  @Value("${http.client.seconds.idle.connection}")
  private int maxSecondsIdleConnection;

  @Value("${http.client.max.client_per_route}")
  private int maxClientPerRoute;

  @Value("${http.client.validate.after.inactivity}")
  private int validateAfterInactivity;

  public ClientConfiguration(ClientRegistrationRepository clientRegistrationRepository) {
    this.clientRegistrationRepository = clientRegistrationRepository;
  }

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder,
                                   @Qualifier("client-http-request-factory") Supplier<ClientHttpRequestFactory> clientHttpRequestFactory) {
    return restTemplateBuilder
              .requestFactory(clientHttpRequestFactory)
              .messageConverters(Arrays.asList(
                      new FormHttpMessageConverter(),
                      new OAuth2AccessTokenResponseHttpMessageConverter()))
              .errorHandler(new OAuth2ErrorResponseErrorHandler())
              .build();
  }

  @Bean("client-http-request-factory")
  Supplier<ClientHttpRequestFactory> defaultClientHttpRequestFactory(
          @Value("${lev.ssl.publicCertificate}") String publicCertificate,
          @Value("${lev.ssl.privateKey}") String privateKey
  ) {
    if (publicCertificate == null || privateKey == null) {
      logger.info("LEV Certificate or private key not set");
      throw new IllegalArgumentException("SSL Certificate or private key cannot be null.");
    } else {
      logger.info("LEV defaultClientHttpRequestFactory with Certificate and private key");
      return () -> {
        try {
          SSLContext sslContext = getSSLContext(publicCertificate, privateKey);
          final SSLConnectionSocketFactory sslConnectionSocketFactory =
                  new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
          final Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                  .register("http", PlainConnectionSocketFactory.getSocketFactory())
                  .register("https", sslConnectionSocketFactory)
                  .build();
          final PoolingHttpClientConnectionManager cm =
                  new PoolingHttpClientConnectionManager(socketFactoryRegistry);
          cm.setMaxTotal(maxTotalHttpClient);
          cm.closeIdleConnections(maxSecondsIdleConnection, TimeUnit.SECONDS);
          cm.setDefaultMaxPerRoute(maxClientPerRoute);
          cm.setValidateAfterInactivity(validateAfterInactivity);
          final CloseableHttpClient httpClient = HttpClients.custom()
                  .setConnectionManager(cm)
                  .setDefaultRequestConfig(getRequestConfig())
                  .build();
          return new HttpComponentsClientHttpRequestFactory(httpClient);
        } catch (IOException | NoSuchAlgorithmException | KeyStoreException | CertificateException |
                 KeyManagementException | UnrecoverableKeyException e) {
          logger.error("Failed to set up HTTP client with SSL context: {}", e.getMessage(), e);
          throw new IllegalStateException("Failed to create HTTP client: " + e.getMessage(), e);

        }
      };
    }
  }

  @Bean
  @ConditionalOnBean(value=RestTemplate.class)
  public RequestInterceptor requestInterceptor( RestTemplate restTemplate,
                                                @Value("${lev.bearertoken.username}") String username,
                                                @Value("${lev.bearertoken.password}") String password
  ) {
    logger.info("requestInterceptor username: {}", username);
    ClientRegistration clientRegistration = clientRegistrationRepository.findByRegistrationId("homeoffice");
    return requestTemplate -> {
      OAuthClientCredentialsFeignManager clientCredentialsFeignManager =
              new OAuthClientCredentialsFeignManager(clientRegistration, restTemplate, username, password);
      requestTemplate.header("Authorization", "Bearer " + clientCredentialsFeignManager.getAccessToken());
    };
  }

  @Bean
  @ConditionalOnProperty(name = "lev.ssl.publicCertificate")
  public Client levClient(
          @Value("${lev.ssl.publicCertificate}") String publicCertificate,
          @Value("${lev.ssl.privateKey}") String privateKey
  )
          throws NoSuchAlgorithmException, KeyStoreException,
          CertificateException, IOException, KeyManagementException, UnrecoverableKeyException {
    if(publicCertificate == null || publicCertificate.isEmpty()){
      logger.info("levClientNoOp()");
      return new Client.Default(null, null);
    } else {
      logger.info("levClient()");
      return new Client.Default(getClientSSLSocketFactory(publicCertificate, privateKey), null);
    }
  }

  private SSLSocketFactory getClientSSLSocketFactory(String publicCertificate, String privateKey)
          throws NoSuchAlgorithmException, KeyStoreException,
          CertificateException, IOException, KeyManagementException, UnrecoverableKeyException
  {
    return getSSLContext(publicCertificate, privateKey).getSocketFactory();
  }

  public SSLContext getSSLContext(String publicCertificate, String privateKey)
          throws NoSuchAlgorithmException, KeyStoreException,
          CertificateException, IOException, KeyManagementException, UnrecoverableKeyException
  {
    SSLContext sslContext = SSLContext.getInstance("TLS");

    KeyStore kStore = KeyStore.getInstance(KeyStore.getDefaultType());

    CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");

    InputStream is = new ByteArrayInputStream(publicCertificate.getBytes());
    X509Certificate certificate = (X509Certificate) certificateFactory.generateCertificate(is);


    PEMParser pemParser = new PEMParser(new StringReader(privateKey));
    Security.addProvider(new BouncyCastleProvider());
    JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");
    Object object = pemParser.readObject();
    KeyPair kp = converter.getKeyPair((PEMKeyPair) object);
    PrivateKey key = kp.getPrivate();

    kStore.load(null);
    kStore.setKeyEntry("alias", key, null, new java.security.cert.Certificate[]{certificate});

    KeyManagerFactory kmf = KeyManagerFactory
            .getInstance(KeyManagerFactory.getDefaultAlgorithm());
    kmf.init(kStore, null);
    KeyManager[] keyManagers = kmf.getKeyManagers();

    if (keyManagers == null) {
      keyManagers = new KeyManager[]{};
    }

    sslContext.init(keyManagers, null, null);
    return sslContext;
  }

  private RequestConfig getRequestConfig() {
    int timeout = 10000;
    return RequestConfig.custom()
            .setConnectTimeout(timeout)
            .setConnectionRequestTimeout(timeout)
            .setSocketTimeout(timeout)
            .setCookieSpec(CookieSpecs.STANDARD)
            .build();
  }
}
