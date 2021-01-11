package com.github.viqbgrg.annotation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:value.yml")
public class ValueConfig {
    private Person person;
    @Value("${person.name}")
    private String name;

    @Autowired
    Environment env;

    @Bean
    public String name() {
        return name;
    }

    @Bean
    public Person person() {
        person = new Person();
        this.person.setName(env.getProperty("name"));
        this.person.setAge(env.getProperty("age", Integer.class));
        return this.person;
    }
}
