package com.github.viqbgrg.springboot.config;


import com.github.viqbgrg.springboot.MyInInterceptor;
import com.github.viqbgrg.springboot.service.impl.HelloWorldImpl;
import jakarta.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class WebServiceConfig {
    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new HelloWorldImpl());
        List<Interceptor<? extends Message>> interceptors = new ArrayList<>();
        interceptors.add(new MyInInterceptor("22222"));
        endpoint.setInInterceptors(interceptors);
        endpoint.publish("/Hello");
        return endpoint;
    }
}