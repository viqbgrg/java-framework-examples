package com.github.viqbgrg.shiro.boot.demo;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hhj
 */
@Configuration
public class ShiroConfig {
    @Bean
    public AuthorizationFilter myHost() {
        return new MyHostFilter();
    }

    @Bean
    public Realm realm() {
        return new SimpleAccountRealm();
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();

        // logged in users with the 'admin' role
        chainDefinition.addPathDefinition("/hello/**", "myHost[123]");

        return chainDefinition;
    }
}
