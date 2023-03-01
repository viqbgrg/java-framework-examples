package com.github.viqbgrg.bootfeatures.externalconfig.service;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class YamlService {

    public String getYamlAValue() {
        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
        yamlPropertiesFactoryBean.setResources(new ClassPathResource("test.yml"));
        Properties object = yamlPropertiesFactoryBean.getObject();
        String property = object.getProperty("test.a");
        return property;
    }
}
