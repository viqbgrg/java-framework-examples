package com.github.viqbgrg.mybatis.plus.dynamic.config;

import com.baomidou.dynamic.datasource.plugin.MasterSlaveAutoRoutingPlugin;
import com.github.viqbgrg.mybatis.plus.dynamic.plugin.MyMasterSlaveAutoRoutingPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hhj
 */
@Configuration
public class MybatisPlusConfig {
    /**
     * 读写分离
     *
     * @return
     */
    @Bean
    public MyMasterSlaveAutoRoutingPlugin masterSlaveAutoRoutingPlugin() {
        return new MyMasterSlaveAutoRoutingPlugin();
    }
}
