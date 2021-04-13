import uk.gov.hmcts.lifeevents.client.api.DeathApiClient;
import uk.gov.hmcts.lifeevents.client.config.ClientConfiguration;
import uk.gov.hmcts.lifeevents.client.config.ServiceConfiguration;
import uk.gov.hmcts.lifeevents.client.service.DeathService;

import feign.Client;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.ApplicationContext;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@EnableAutoConfiguration
@ExtendWith(SpringExtension.class)
@SpringBootTest(
        classes = { ClientConfiguration.class, ServiceConfiguration.class }
)
@EnableConfigurationProperties
@ContextConfiguration()
public class AutoConfigurationTest {

    @Autowired
    private ApplicationContext context;

    @DisplayName("Should have Api configured")
    @Test
    public void haveApi() {
        assertThat(context.getBeanNamesForType(DeathApiClient.class)).hasSize(1);
        assertThat(context.getBeanNamesForType(DeathService.class)).hasSize(1);
        assertThat(context.getBeanNamesForType(ResourceOwnerPasswordResourceDetails.class)).hasSize(1);
        assertThat(context.getBeanNamesForType(OAuth2FeignRequestInterceptor.class)).hasSize(1);
        assertThat(context.getBeanNamesForType(Client.class)).hasSize(1);
    }
}
