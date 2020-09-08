package com.github.viqbgrg.bootfeatures.externalconfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class MyApplicationTest {

    @Autowired
    private String name;
    @Autowired
    private String secret;
    @Autowired
    private String number;

    @Value("${devName}")
    private String devName;

    @Test
    void testName() {
        assertThat(name).isEqualTo("test");
    }

    @Test
    void testRandom() {
        assertThat(secret).isNotEmpty();
        assertThat(number).isNotEmpty();
    }

    @Test
    void testProfilesActive() {
        assertThat(devName).isEqualTo("devName");
    }
}