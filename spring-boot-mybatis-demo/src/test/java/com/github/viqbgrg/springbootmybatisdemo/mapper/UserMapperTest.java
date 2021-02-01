package com.github.viqbgrg.springbootmybatisdemo.mapper;
import com.github.viqbgrg.springbootmybatisdemo.domain.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@MybatisTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    /**
     * 把json数组转换成List
     */
    @Test
    void testJsonArrayToList() {
        List<User> users = userMapper.selectAll();
        System.out.println(users);
    }
}
