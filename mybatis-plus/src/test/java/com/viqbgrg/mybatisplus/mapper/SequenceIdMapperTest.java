package com.viqbgrg.mybatisplus.mapper;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import com.viqbgrg.mybatisplus.config.MybatisConfig;
import com.viqbgrg.mybatisplus.entity.SequenceId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

@MybatisPlusTest
@Import(MybatisConfig.class)
class SequenceIdMapperTest {
    @Autowired
    private SequenceIdMapper mapper;

    @Test
    void addKey() {
        SequenceId keyId = new SequenceId();
        keyId.setName("小明");
        mapper.insert(keyId);
        System.out.println(keyId.getId());
    }
}