package com.github.viqbgrg.bootfeatures.externalconfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MyBeanTest {

    @Autowired
    private String testString;

    @Autowired
    private String defaultString;

    @Test
    void testString() {
        assertThat(testString).isEqualTo("hello");
    }

    @Test
    void defaultString() {
        assertThat(defaultString).isEqualTo("world");
    }
}