package com.github.viqbgrg.bootfeatures.externalconfig.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesCustom {

    @Bean
    @ConfigurationProperties(prefix = "testbean")
    public TestBean getTestBean() {
        return new TestBean();
    }
}
