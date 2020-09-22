package com.github.viqbgrg.bootfeatures.externalconfig.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationTest {

    @Bean
    @ConfigurationProperties(prefix = "acme-bean.user")
    public AcmeProperties.User getUser() {
        return new AcmeProperties.User();
    }
}
