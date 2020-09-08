package com.github.viqbgrg.bootfeatures.externalconfig;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class MyApplicationTest {

    @Autowired
    private String name;

    @Test
    void testName() {
        Assertions.assertThat(name).isEqualTo("test");
    }
}