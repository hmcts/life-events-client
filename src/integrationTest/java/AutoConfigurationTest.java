import com.github.hmcts.lifeevents.client.api.DeathApiClient;
import com.github.hmcts.lifeevents.client.api.TestOAuth2Config;
import com.github.hmcts.lifeevents.client.config.ClientConfiguration;
import com.github.hmcts.lifeevents.client.config.ServiceConfiguration;
import com.github.hmcts.lifeevents.client.service.DeathService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = { ClientConfiguration.class, ServiceConfiguration.class, TestOAuth2Config.class })
@EnableAutoConfiguration
@EnableConfigurationProperties
class AutoConfigurationTest {

    @Autowired
    private ApplicationContext context;

    @DisplayName("Should have API beans configured")
    @Test
    void haveApi() {
        assertThat(context.getBeanNamesForType(DeathApiClient.class)).hasSize(1);
        assertThat(context.getBeanNamesForType(DeathService.class)).hasSize(1);
        assertThat(context.getBeanNamesForType(RestTemplate.class)).hasSize(1);
    }
}