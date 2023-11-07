package com.github.viqbgrg.springboot.config;

import com.github.viqbgrg.springboot.service.HelloWorld;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfiguration {
    @Bean
    public JaxWsProxyFactoryBean proxyFactoryBean() {
        JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
        proxyFactory.setServiceClass(HelloWorld.class);
        proxyFactory.setAddress("http://localhost:8080/services/Hello");
        return proxyFactory;
    }

    @Bean(name = "client")
    public HelloWorld generateProxy() {
        return (HelloWorld) proxyFactoryBean().create();
    }
}
