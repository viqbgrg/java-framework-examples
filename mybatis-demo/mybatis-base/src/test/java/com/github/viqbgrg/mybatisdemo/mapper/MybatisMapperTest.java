package com.github.viqbgrg.mybatisdemo.mapper;

import com.github.viqbgrg.mybatisdemo.MybatisConfig;
import com.github.viqbgrg.mybatisdemo.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class MybatisMapperTest {
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeAll
    static void setSessionFactory() throws IOException {
        sqlSessionFactory = MybatisConfig.sqlSessionFactory();
    }

    @Test
    void selectUser() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.selectUser(1);
            assertThat(user).isNotNull();
            assertThat(user.getUpdateAt()).isNotNull();
            assertThat(user.getUpdateAt()).isNotNull();
        }
    }

}