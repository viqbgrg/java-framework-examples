package com.github.viqbgrg.shiro.boot.mvc.filter.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author hhj
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    private final MyInterceptor1 myInterceptor1;

    public InterceptorConfig(MyInterceptor1 myInterceptor1) {
        this.myInterceptor1 = myInterceptor1;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor1);
    }
}
