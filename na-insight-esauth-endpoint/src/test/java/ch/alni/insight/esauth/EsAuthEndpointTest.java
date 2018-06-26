package ch.alni.insight.esauth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.test.server.MockWebServiceClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

@RunWith(SpringJUnit4ClassRunner.class)
public class EsAuthEndpointTest extends EsAuthPointTestSupport {

    private static final Logger LOG = getLogger(EsAuthEndpointTest.class);

    @Value("classpath:logout.xml")
    private Resource logoutXml;

    @Autowired
    private MockWebServiceClient mockWebServiceClient;

    @Test
    public void testLogout() {
        assertThat(mockWebServiceClient).isNotNull();
        // do not use methods of the RequestCreators class, they contain bugs as of the version spring-test-3.0.1
        mockWebServiceClient.sendRequest(messageFactory -> messageFactory.createWebServiceMessage(logoutXml.getInputStream()));
        LOG.info("testLogout");
    }

}