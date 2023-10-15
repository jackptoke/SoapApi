package dev.toke.capitalsoapapi.soap;

import org.apache.wss4j.dom.WSConstants;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurer;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.server.endpoint.adapter.method.MethodArgumentResolver;
import org.springframework.ws.server.endpoint.adapter.method.MethodReturnValueHandler;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.soap.security.wss4j2.callback.SimplePasswordValidationCallbackHandler;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import javax.security.auth.callback.CallbackHandler;
import java.util.Collections;
import java.util.List;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    // MessageDispatcherServlet
        //ApplicationContext
    //url --> /ws/*
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(messageDispatcherServlet, "/ws/*");
    }

    @Bean(name="components")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema componentSchema) {
        DefaultWsdl11Definition def = new DefaultWsdl11Definition();
        def.setPortTypeName("ComponentPort");
        def.setTargetNamespace("http://www.toke.dev/components");
        def.setLocationUri("/ws");
        def.setSchema(componentSchema);
        return def;
    }

    @Bean
    public XsdSchema componentSchema() {
        return new SimpleXsdSchema(new ClassPathResource("component-detail.xsd"));
    }

    @Bean
    public Wss4jSecurityInterceptor securityInterceptor() {
        Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();
        securityInterceptor.setSecurementActions("UsernameToken");
        securityInterceptor.setSecurementPasswordType(WSConstants.PW_TEXT);
        securityInterceptor.setSecurementUsername("AME\\jackt");
        securityInterceptor.setSecurementPassword("UpSiDeDoWn");

        return securityInterceptor;
    }

    @Bean
    protected SimplePasswordValidationCallbackHandler callbackHandler() {
        SimplePasswordValidationCallbackHandler handler = new SimplePasswordValidationCallbackHandler();
        handler.setUsersMap(Collections.singletonMap("user", "password"));
        return handler;
    }
    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        interceptors.add(securityInterceptor());
    }

}
