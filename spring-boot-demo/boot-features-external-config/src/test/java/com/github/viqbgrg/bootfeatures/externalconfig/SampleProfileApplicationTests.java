package com.github.viqbgrg.bootfeatures.externalconfig;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(OutputCaptureExtension.class)
public class SampleProfileApplicationTests {
    private String profiles;

    @BeforeEach
    void before() {
        this.profiles = System.getProperty("spring.profiles.active");
    }

    @AfterEach
    void after() {
        if (this.profiles != null) {
            System.setProperty("spring.profiles.active", this.profiles);
        } else {
            System.clearProperty("spring.profiles.active");
        }
    }

    @Test
    void testDefaultProfile(CapturedOutput output) {
        MyApplication.main(new String[0]);
        assertThat(output).contains("Hello Phil");
    }

    @Test
    void testGoodbyeProfile(CapturedOutput output) {
        System.setProperty("spring.profiles.active", "goodbye");
        MyApplication.main(new String[0]);
        assertThat(output).contains("Goodbye Everyone");
    }
}
