package com.github.viqbgrg.mybatis_demo;

import org.apache.ibatis.session.SqlSessionFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class MybatisDemoTest {

    @Test
    void sqlSessionFactory() throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisDemo.sqlSessionFactory();
        Assertions.assertThat(sqlSessionFactory).isNotNull();
    }
}