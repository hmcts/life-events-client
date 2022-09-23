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
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

import feign.Client;
import feign.RequestInterceptor;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.AuthorizedClientServiceOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizationContext;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

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
  public OAuth2AuthorizedClientManager authorizedClientManager( @Value("${lev.bearertoken.username}") String username, @Value("${lev.bearertoken.password}") String password) {
    logger.info("authorizedClientManager() username: " + username);
    OAuth2AuthorizedClientProvider authorizedClientProvider = OAuth2AuthorizedClientProviderBuilder.builder()
        .password()
        .refreshToken()
        .build();

    AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientManager =
        new AuthorizedClientServiceOAuth2AuthorizedClientManager(clientRegistrationRepository, oAuth2AuthorizedClientService);
    authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);
    authorizedClientManager.setContextAttributesMapper(contextAttributesMapper(username, password));
    return authorizedClientManager;
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
  public RequestInterceptor requestInterceptor( OAuth2AuthorizedClientManager authorizedClientManager) {
    logger.info("requestInterceptor()");
    ClientRegistration clientRegistration = clientRegistrationRepository.findByRegistrationId("homeoffice");
    OAuthClientCredentialsFeignManager clientCredentialsFeignManager =
        new OAuthClientCredentialsFeignManager(authorizedClientManager, clientRegistration);
    return requestTemplate -> {
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

    return sslContext.getSocketFactory();
  }
}
