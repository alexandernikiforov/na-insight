package ch.alni.insight.esauth;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.test.server.MockWebServiceClient;

@Configuration
public class EsAuthEndpointTestConfig {

    @Bean
    public MockWebServiceClient mockWebServiceClient(ApplicationContext applicationContext) {
        return MockWebServiceClient.createClient(applicationContext);
    }
}
