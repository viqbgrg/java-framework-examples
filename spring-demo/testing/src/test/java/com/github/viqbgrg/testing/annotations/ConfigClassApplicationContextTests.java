package com.github.viqbgrg.testing.annotations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
class ConfigClassApplicationContextTests {
    @Autowired
    Person person;
    @Autowired
    ApplicationContext applicationContext;

    @Test
    void testContext() {
        assertThat(person).isNotNull();
        assertThat(person.getUsername()).isEqualTo("xiaoming");
        assertThat(person.getPassword()).isEqualTo("123456");
    }
}