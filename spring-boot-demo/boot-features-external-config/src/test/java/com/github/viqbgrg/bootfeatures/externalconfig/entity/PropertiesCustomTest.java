package com.github.viqbgrg.bootfeatures.externalconfig.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class PropertiesCustomTest {

    @Autowired
    private TestBean testBean;


    @Autowired
    private Environment environment;


    @Test
    void getTestBean() {
        assertThat(environment).isNotNull();
        assertThat(testBean.getName()).isNotEmpty();
    }
}