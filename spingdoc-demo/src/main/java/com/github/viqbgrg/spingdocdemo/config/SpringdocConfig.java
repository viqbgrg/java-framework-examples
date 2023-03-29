package com.github.viqbgrg.spingdocdemo.config;


import com.github.viqbgrg.spingdocdemo.model.Result;
import jakarta.annotation.PostConstruct;
import org.springdoc.core.utils.SpringDocUtils;
import org.springframework.context.annotation.Configuration;

/**
 * springdoc 配置文件
 */
@Configuration
public class SpringdocConfig {
    @PostConstruct
    public void initConfig() {
        SpringDocUtils.getConfig().addResponseWrapperToIgnore(Result.class);
    }
}
