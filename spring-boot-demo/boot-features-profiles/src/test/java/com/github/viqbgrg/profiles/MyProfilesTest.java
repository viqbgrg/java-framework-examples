package com.github.viqbgrg.profiles;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("dev2")
class MyProfilesTest {
    @Autowired
    private MyProfiles.MyBean myBean;

    @Test
    void myBeanName() {
//        Assertions.assertThat(myBean.getUsername()).isEqualTo("dev");
        assertThat(myBean.getUsername()).isEqualTo("hello");
    }
}