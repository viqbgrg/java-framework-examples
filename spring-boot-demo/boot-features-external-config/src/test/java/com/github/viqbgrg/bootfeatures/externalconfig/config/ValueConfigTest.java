package com.github.viqbgrg.bootfeatures.externalconfig.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ValueConfigTest {
    @Autowired
    private ValueConfig valueConfig;


    @Test
    void test() {
        assertThat(valueConfig.getName()).isEqualTo("haha");
        assertThat(valueConfig.getSize()).isEqualTo(18);
    }
}