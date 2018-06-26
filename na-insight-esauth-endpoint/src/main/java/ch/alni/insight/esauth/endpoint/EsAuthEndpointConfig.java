package ch.alni.insight.esauth.endpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;

import java.util.List;

@Configuration
@ComponentScan
@EnableWs
public class EsAuthEndpointConfig extends WsConfigurerAdapter {

    @Value("classpath:wsdl/AuthenticationManagerOperations.wsdl")
    private Resource esAuthWsdlResource;

    @Value("classpath:wsdl/esauth.xsd")
    private Resource esAuthProtocolXsd;

    @Value("classpath:wsdl/esauth-xsd.xsd")
    private Resource esAuthTypeXsd;

    @Bean
    public SimpleWsdl11Definition esauth() throws Exception {
        SimpleWsdl11Definition definition = new SimpleWsdl11Definition(esAuthWsdlResource);
        definition.afterPropertiesSet();
        return definition;
    }

    @Bean
    public EndpointInterceptor validatingInterceptor() {
        PayloadValidatingInterceptor validatingInterceptor = new PayloadValidatingInterceptor();
        // the order of schemas is important
        validatingInterceptor.setSchemas(esAuthTypeXsd, esAuthProtocolXsd);
        validatingInterceptor.setValidateRequest(true);
        validatingInterceptor.setValidateResponse(false);

        try {
            validatingInterceptor.afterPropertiesSet();
        } catch (Exception e) {
            throw new IllegalStateException("cannot add PayloadValidatingInterceptor", e);
        }

        return validatingInterceptor;
    }

    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        interceptors.add(validatingInterceptor());
    }
    

}
