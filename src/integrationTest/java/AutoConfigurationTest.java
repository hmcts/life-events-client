import com.github.hmcts.lifeevents.client.api.DeathApiClient;
import com.github.hmcts.lifeevents.client.config.ClientConfiguration;
import com.github.hmcts.lifeevents.client.config.ServiceConfiguration;
import com.github.hmcts.lifeevents.client.service.DeathService;
import feign.Client;
import feign.RequestInterceptor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

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
        assertThat(context.getBeanNamesForType(RestTemplate.class)).hasSize(1);
        assertThat(context.getBeanNamesForType(RequestInterceptor.class)).hasSize(1);
        assertThat(context.getBeanNamesForType(Client.class)).hasSize(1);
    }
}
