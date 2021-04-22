package com.viqbgrg.mybatisplus.config;

import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import com.baomidou.mybatisplus.extension.incrementer.H2KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hhj
 */
@Configuration
public class MybatisConfig {
    @Bean
    public IKeyGenerator keyGenerator() {
        return new H2KeyGenerator();
    }


}
