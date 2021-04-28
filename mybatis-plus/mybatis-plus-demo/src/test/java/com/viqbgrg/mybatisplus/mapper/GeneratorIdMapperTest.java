package com.viqbgrg.mybatisplus.mapper;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import com.viqbgrg.mybatisplus.entity.GeneratorId;
import com.viqbgrg.mybatisplus.mybatis.CustomIdGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@MybatisPlusTest
@Import(CustomIdGenerator.class)
class GeneratorIdMapperTest {
    @Autowired
    private GeneratorIdMapper mapper;

    @Test
    void generatorId() {
        GeneratorId generatorId = new GeneratorId();
        mapper.insert(generatorId);
        assertThat(generatorId.getId()).isNotNull();
    }
}