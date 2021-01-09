package com.github.viqbgrg.bootfeatures.externalconfig.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource("classpath:test.yml")
class PropertiesCustomTest {

    @Autowired
    private TestBean testBean;

    @Test
    void getTestBean() {
        assertThat(testBean).isNotNull();
    }
}