package com.github.viqbgrg.testing.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    @Bean
    public Person getPerson() {
        Person person = new Person();
        person.setUsername("xiaoming");
        person.setPassword("123456");
        return person;
    }
}
