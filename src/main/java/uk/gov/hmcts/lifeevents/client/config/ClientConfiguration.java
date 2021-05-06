package uk.gov.hmcts.lifeevents.client.config;

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

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

import feign.Client;
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
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;

@EnableConfigurationProperties
public class ClientConfiguration {

  private static final Logger logger = LoggerFactory.getLogger(ClientConfiguration.class);

  @Bean
  @ConditionalOnProperty(name = "lev.bearertoken.clientId")
  public ResourceOwnerPasswordResourceDetails bearerTokenResourceDetails(
          @Value("${lev.bearertoken.accessTokenUri:https://sso.digital.homeoffice.gov.uk/auth/realms/lev/protocol/openid-connect/token}") String accessTokenUri,
          @Value("${lev.bearertoken.clientId}") String clientId,
          @Value("${lev.bearertoken.clientSecret}") String clientSecret,
          @Value("${lev.bearertoken.username}") String userName,
          @Value("${lev.bearertoken.password}") String password

  ) {
    logger.info("bearerTokenResourceDetails()");
    ResourceOwnerPasswordResourceDetails details = new ResourceOwnerPasswordResourceDetails();
    details.setAccessTokenUri(accessTokenUri);
    details.setClientId(clientId);
    details.setClientSecret(clientSecret);
    details.setUsername(userName);
    details.setPassword(password);
    return details;
  }

  @Bean
  @ConditionalOnBean(value=ResourceOwnerPasswordResourceDetails.class)
  public OAuth2FeignRequestInterceptor bearerTokenRequestInterceptor(ResourceOwnerPasswordResourceDetails bearerTokenResourceDetails) {
    logger.info("bearerTokenRequestInterceptor()");
    return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), bearerTokenResourceDetails);
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
