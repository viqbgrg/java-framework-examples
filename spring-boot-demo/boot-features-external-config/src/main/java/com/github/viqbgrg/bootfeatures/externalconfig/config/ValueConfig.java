package com.github.viqbgrg.bootfeatures.externalconfig.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author hhj
 */
@Configuration
@ConfigurationProperties("value")
@Data
public class ValueConfig {
    private String name;
    private int size;
}
