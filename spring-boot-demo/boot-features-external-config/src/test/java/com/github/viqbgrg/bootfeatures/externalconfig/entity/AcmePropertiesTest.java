package com.github.viqbgrg.bootfeatures.externalconfig.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AcmePropertiesTest {
    @Autowired
    private AcmeProperties properties;

    @Autowired
    private AcmeProperties.User user;

    @Test
    void testProperties() {
        Assertions.assertThat(properties).isNotNull();
        Assertions.assertThat(user.getUsername()).isNotEmpty();
    }
}