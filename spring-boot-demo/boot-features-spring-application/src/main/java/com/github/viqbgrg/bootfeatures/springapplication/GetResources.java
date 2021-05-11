package com.github.viqbgrg.bootfeatures.springapplication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author hhj
 */
@Configuration
@Slf4j
public class GetResources {
    @Bean
    public File getFile() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("test.txt");
        InputStream inputStream = classPathResource.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        File file = classPathResource.getFile();

        log.info("路径: {}", file.getAbsolutePath());
        return classPathResource.getFile();
    }
}
