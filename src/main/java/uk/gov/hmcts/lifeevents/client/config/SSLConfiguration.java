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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SSLConfiguration {

    @Autowired
    SSLSocketFactory sslSocketFactory;

    @Bean
    public Client getfeignClient() {
        return new Client.Default(sslSocketFactory, null);
    }

    @Bean
    public SSLSocketFactory getClientSSLSocketFactory(
            @Value("${ssl.publicCertificate}") String publicCertificate,
            @Value("${ssl.privateKey}") String privateKey
    )
            throws NoSuchAlgorithmException, KeyStoreException,
            CertificateException, IOException, KeyManagementException, UnrecoverableKeyException {

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
            // 2-way TLS not required. Let JVM uses its default
            keyManagers = new KeyManager[]{};
        }

        sslContext.init(keyManagers, null, null);

        return sslContext.getSocketFactory();
    }
}
