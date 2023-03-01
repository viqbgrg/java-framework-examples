package com.github.viqbgrg.bootfeatures.externalconfig.config;

import com.github.viqbgrg.bootfeatures.externalconfig.entity.OneProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(OneProperties.class)
public class UserConfig {
}
