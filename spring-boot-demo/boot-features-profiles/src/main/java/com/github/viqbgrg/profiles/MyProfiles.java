package com.github.viqbgrg.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MyProfiles {
    @Bean
    @Profile("dev")
    public MyBean devName() {
        return new MyBean("dev");
    }

    @Bean
    @Profile("dev2")
    public MyBean getName() {
        return new MyBean("hello");
    }

    public static class MyBean {
        private String username;

        public MyBean(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

}
