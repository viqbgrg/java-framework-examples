package com.viqbgrg.mybatisplus.mapper;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import com.viqbgrg.mybatisplus.entity.EnumTest;
import com.viqbgrg.mybatisplus.entity.Status;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@MybatisPlusTest
//@SpringBootTest
class EnumTestMapperTest {
    @Autowired
    private EnumTestMapper mapper;

    @Test
    void save() {
        EnumTest enumTest = new EnumTest();
        enumTest.setStatus(Status.CLOSE);
        mapper.insert(enumTest);
    }

    @Test
    void select() {
        List<EnumTest> enumTests = mapper.selectList(null);
        Assertions.assertThat(enumTests).isNotNull();
    }

}