package com.github.viqbgrg.bootfeatures.externalconfig;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
class MyApplicationTest {

    @Autowired
    private String name;
    @Autowired
    private String secret;
    @Autowired
    private String number;

    @Test
    void testName() {
        assertThat(name).isEqualTo("test");
    }

    @Test
    void testRandom() {
        assertThat(secret).isNotEmpty();
        assertThat(number).isNotEmpty();
    }
}