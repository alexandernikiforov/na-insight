package ch.alni.insight.application;

import ch.alni.insight.esauth.endpoint.EsAuthEndpointConfig;
import ch.alni.insight.web.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
        EsAuthEndpointConfig.class,
        WebConfig.class
})
public class InsightApplication {

    public static void main(String[] args) {
        SpringApplication.run(InsightApplication.class, args);
    }
}
