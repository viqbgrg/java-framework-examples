package com.github.viqbgrg.mybatis.sqlmap.mapper;

import com.github.viqbgrg.mybatis.sqlmap.entity.User;
import com.github.viqbgrg.test.MybatisBaseTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class UserMapperTest extends MybatisBaseTest<UserMapper> {

    @Test
    void selectUserAndBookId() {
        UserMapper mapper = this.sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectUserAndBookId();
        assertThat(users).isNotEmpty();
    }
}