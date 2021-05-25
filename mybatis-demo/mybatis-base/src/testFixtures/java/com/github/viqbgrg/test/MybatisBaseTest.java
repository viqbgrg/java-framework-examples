package com.github.viqbgrg.test;


import com.github.viqbgrg.base.MybatisBase;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;

public abstract class MybatisBaseTest {
    protected static SqlSession sqlSession;

    @BeforeAll
    static void setSqlSession() throws IOException {
        MybatisBase mybatisBase = new MybatisBase();
        SqlSessionFactory sqlSessionFactory = mybatisBase.createSqlSessionFactory();
        sqlSession = sqlSessionFactory.openSession();
    }

}