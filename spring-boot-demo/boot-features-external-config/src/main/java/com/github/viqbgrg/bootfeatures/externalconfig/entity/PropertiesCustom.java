package com.github.viqbgrg.bootfeatures.externalconfig.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:test.yml")
public class PropertiesCustom {

    @Bean
    @ConfigurationProperties(prefix = "testbean")
    public TestBean getTestBean() {
        return new TestBean();
    }
}
