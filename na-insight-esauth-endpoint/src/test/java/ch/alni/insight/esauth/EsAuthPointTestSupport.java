package ch.alni.insight.esauth;

import ch.alni.insight.esauth.endpoint.EsAuthEndpointConfig;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {
        EsAuthEndpointConfig.class, EsAuthEndpointTestConfig.class
})
class EsAuthPointTestSupport {
}
