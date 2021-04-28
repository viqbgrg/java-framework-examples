package com.github.viqbgrg.mybatisplus.injectordemo;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@MybatisPlusTest
@Import({MybatisPlusConfig.class})
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void test() {
        List<User> users = userMapper.selectAll();
        assertThat(users.size()).isGreaterThan(0);
    }
}