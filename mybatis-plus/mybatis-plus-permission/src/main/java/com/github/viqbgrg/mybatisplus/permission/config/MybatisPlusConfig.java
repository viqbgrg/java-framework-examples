package com.github.viqbgrg.mybatisplus.permission.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.github.viqbgrg.mybatisplus.permission.mybatis.MyDataPermissionHandler;
import com.github.viqbgrg.mybatisplus.permission.mybatis.MyDataPermissionInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.github.viqbgrg.mybatisplus.permission.mapper")
public class MybatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        MyDataPermissionInterceptor myDataPermissionInterceptor = new MyDataPermissionInterceptor();
        MyDataPermissionHandler myDataPermissionHandler = new MyDataPermissionHandler();
        myDataPermissionInterceptor.setDataPermissionHandler(myDataPermissionHandler);
        interceptor.addInnerInterceptor(myDataPermissionInterceptor);
        return interceptor;
    }

}
