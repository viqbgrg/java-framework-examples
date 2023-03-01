package com.github.viqbgrg.bootfeatures.externalconfig.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "user")
@Data
public class OneProperties {
    private String a;

    private Integer b;
}
