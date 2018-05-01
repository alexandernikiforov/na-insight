package ch.alni.insight.esauth.endpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;

@Configuration
@ComponentScan
@EnableWs
public class EsAuthEndpointConfig extends WsConfigurerAdapter {

    @Value("classpath:wsdl/AuthenticationManagerOperations.wsdl")
    private Resource esAuthWsdlResource;

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();

        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);

        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean
    public SimpleWsdl11Definition esauth() throws Exception {
        SimpleWsdl11Definition definition = new SimpleWsdl11Definition();
        definition.setWsdl(esAuthWsdlResource);
        definition.afterPropertiesSet();
        return definition;
    }

}
