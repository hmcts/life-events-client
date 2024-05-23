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
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
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
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
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
import org.springframework.security.oauth2.client.AuthorizedClientServiceOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizationContext;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.endpoint.DefaultPasswordTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.DefaultRefreshTokenTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2PasswordGrantRequest;
import org.springframework.security.oauth2.client.endpoint.OAuth2RefreshTokenGrantRequest;
import org.springframework.security.oauth2.client.endpoint.OAuth2RefreshTokenGrantRequestEntityConverter;
import org.springframework.security.oauth2.client.http.OAuth2ErrorResponseErrorHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.security.oauth2.core.http.converter.OAuth2AccessTokenResponseHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@EnableConfigurationProperties
public class ClientConfiguration {

  private static final Logger logger = LoggerFactory.getLogger(ClientConfiguration.class);

  private final OAuth2AuthorizedClientService oAuth2AuthorizedClientService;
  private final ClientRegistrationRepository clientRegistrationRepository;

  public ClientConfiguration(OAuth2AuthorizedClientService oAuth2AuthorizedClientService,
                          ClientRegistrationRepository clientRegistrationRepository) {
    this.oAuth2AuthorizedClientService = oAuth2AuthorizedClientService;
    this.clientRegistrationRepository = clientRegistrationRepository;
  }

  @Bean
  public OAuth2AuthorizedClientManager authorizedClientManager( @Value("${lev.bearertoken.username}") String username,
                                                                @Value("${lev.bearertoken.password}") String password,
                                                                RestTemplateBuilder restTemplateBuilder,
                                                                @Qualifier("client-http-request-factory") Supplier<ClientHttpRequestFactory> clientHttpRequestFactory) {

    Supplier<RestTemplate> restTemplateSupplier = () -> restTemplateBuilder
            .requestFactory(clientHttpRequestFactory)
            .messageConverters(Arrays.asList(
                    new FormHttpMessageConverter(),
                    new OAuth2AccessTokenResponseHttpMessageConverter()))
            .errorHandler(new OAuth2ErrorResponseErrorHandler())
            .build();
    logger.info("authorizedClientManager() username: " + username);
    OAuth2AuthorizedClientProvider authorizedClientProvider = OAuth2AuthorizedClientProviderBuilder.builder()
        .password(passwordGrantRequestEntity ->
                passwordGrantRequestEntity.accessTokenResponseClient(
                        createPasswordTokenResponseClient(restTemplateSupplier.get())))
        .refreshToken(refreshToken ->
                refreshToken.accessTokenResponseClient(
                        createRefreshTokenResponseClient(restTemplateSupplier.get())))
        .build();

    AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientManager =
        new AuthorizedClientServiceOAuth2AuthorizedClientManager(clientRegistrationRepository, oAuth2AuthorizedClientService);
    authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);
    authorizedClientManager.setContextAttributesMapper(contextAttributesMapper(username, password));
    return authorizedClientManager;
  }

  @Bean("client-http-request-factory")
  Supplier<ClientHttpRequestFactory> defaultClientHttpRequestFactory(
          @Value("${lev.ssl.publicCertificate}") String publicCertificate,
          @Value("${lev.ssl.privateKey}") String privateKey
  ) {
    if (publicCertificate == null || privateKey == null) {
      logger.info("LEV Certificate or private key not set");
      return () -> new HttpComponentsClientHttpRequestFactory(getHttpClient());
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
          final BasicHttpClientConnectionManager connectionManager =
                  new BasicHttpClientConnectionManager(socketFactoryRegistry);
          final CloseableHttpClient httpClient = HttpClients.custom()
                  .setConnectionManager(connectionManager)
                  .setDefaultRequestConfig(getRequestConfig())
                  .build();
          return new HttpComponentsClientHttpRequestFactory(httpClient);
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      };
    }
  }

  private static OAuth2AccessTokenResponseClient<OAuth2PasswordGrantRequest> createPasswordTokenResponseClient(
          RestTemplate restTemplate) {
    DefaultPasswordTokenResponseClient passwordTokenResponseClient =
            new DefaultPasswordTokenResponseClient();
    passwordTokenResponseClient.setRestOperations(restTemplate);
    return passwordTokenResponseClient;
  }

  private static OAuth2AccessTokenResponseClient<OAuth2RefreshTokenGrantRequest> createRefreshTokenResponseClient(
          RestTemplate restTemplate) {
    DefaultRefreshTokenTokenResponseClient refreshTokenResponseClient =
            new DefaultRefreshTokenTokenResponseClient();
    refreshTokenResponseClient.setRestOperations(restTemplate);
    OAuth2RefreshTokenGrantRequestEntityConverter refreshTokenGrantRequestEntityConverter = new OAuth2RefreshTokenGrantRequestEntityConverter();
    refreshTokenGrantRequestEntityConverter.addParametersConverter(authorizationGrantRequest -> {
      MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
      parameters.add(OAuth2ParameterNames.REFRESH_TOKEN, authorizationGrantRequest.getRefreshToken().getTokenValue());
        logger.info("OAuth2AccessTokenResponseClient Refresh token: {}", authorizationGrantRequest.getRefreshToken().getTokenValue());
      return parameters;
    });
    refreshTokenResponseClient.setRequestEntityConverter(refreshTokenGrantRequestEntityConverter);
    return refreshTokenResponseClient;
  }

  private Function<OAuth2AuthorizeRequest, Map<String, Object>> contextAttributesMapper(final String username, final String password) {
    return authorizeRequest -> {
      final Map<String, Object> contextAttributes = new HashMap<>();
      contextAttributes.put(OAuth2AuthorizationContext.USERNAME_ATTRIBUTE_NAME, username);
      contextAttributes.put(OAuth2AuthorizationContext.PASSWORD_ATTRIBUTE_NAME, password);
      return contextAttributes;
    };
  }

  @Bean
  @ConditionalOnBean(value=OAuth2AuthorizedClientManager.class)
  public RequestInterceptor requestInterceptor( OAuth2AuthorizedClientManager authorizedClientManager, @Qualifier("client-http-request-factory") Supplier<ClientHttpRequestFactory> clientHttpRequestFactory,
                                                @Value("${lev.bearertoken.username}") String username,
                                                @Value("${lev.bearertoken.password}") String password
  ) {
    logger.info("requestInterceptor()");
    ClientRegistration clientRegistration = clientRegistrationRepository.findByRegistrationId("homeoffice");
    OAuth2AuthorizedClient authorizedClient = oAuth2AuthorizedClientService.loadAuthorizedClient(clientRegistration.getRegistrationId(), clientRegistration.getClientId());
    if (authorizedClient != null) {
      logger.info("removeAuthorizedClient");
      oAuth2AuthorizedClientService.removeAuthorizedClient(clientRegistration.getRegistrationId(), clientRegistration.getClientId());
    }
    RestTemplateConfiguration restTemplateConfiguration = new RestTemplateConfiguration(clientHttpRequestFactory);
    return requestTemplate -> {
      OAuthClientCredentialsFeignManager clientCredentialsFeignManager =
              new OAuthClientCredentialsFeignManager(authorizedClientManager, clientRegistration, oAuth2AuthorizedClientService, restTemplateConfiguration, username, password);
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

  private CloseableHttpClient getHttpClient() {
    return HttpClientBuilder
            .create()
            .useSystemProperties()
            .disableRedirectHandling()
            .setDefaultRequestConfig(getRequestConfig())
            .build();
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
