package com.viqbgrg.mybatisplus.mapper;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
@MybatisPlusTest
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void userMapperTest() {
        assertThat(userMapper).isNotNull();
    }
}