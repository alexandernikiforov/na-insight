package ch.alni.insight.esauth.endpoint;

import ch.alni.insight.esauth.protocol.*;
import org.slf4j.Logger;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Endpoint for handling communication with nevisproxy's EsAuthConnector.
 */
@Endpoint
public class EsAuthEndpoint {
    private static final Logger LOG = getLogger(EsAuthEndpoint.class);

    private static final String NAMESPACE_URI = "http://soap.esauth.nevis.ch";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "authenticate")
    @ResponsePayload
    public AuthenticateResponse authenticate(Authenticate authenticateRequest) {
        LOG.info("authenticate {}", authenticateRequest);
        return new AuthenticateResponse();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "stepup")
    @ResponsePayload
    public StepupResponse stepUp(Stepup stepUpRequest) {
        LOG.info("stepUp {}", stepUpRequest);
        return new StepupResponse();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "logout")
    @ResponsePayload
    public LogoutResponse logout(Logout logoutRequest) {
        LOG.info("logout {}", logoutRequest);
        return new LogoutResponse();
    }

}
