package com.github.viqbgrg.testing.annotations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig(TestConfig.class)
public class Junit5Test {
    @Autowired
    Person person;

    @Test
    void junitTest() {
        assertThat(person).isNotNull();
        assertThat(person.getUsername()).isEqualTo("xiaoming");
        assertThat(person.getPassword()).isEqualTo("123456");
    }
}
