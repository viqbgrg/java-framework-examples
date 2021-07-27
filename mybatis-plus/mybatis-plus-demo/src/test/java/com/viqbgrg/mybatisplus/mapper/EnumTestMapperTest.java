package com.viqbgrg.mybatisplus.mapper;

import com.viqbgrg.mybatisplus.entity.EnumTest;
import com.viqbgrg.mybatisplus.entity.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@MybatisPlusTest
@SpringBootTest
class EnumTestMapperTest {
    @Autowired
    private EnumTestMapper mapper;

    @Test
    void save() {
        EnumTest enumTest = new EnumTest();
        enumTest.setStatus(Status.CLOSE);
        mapper.insert(enumTest);
    }

}