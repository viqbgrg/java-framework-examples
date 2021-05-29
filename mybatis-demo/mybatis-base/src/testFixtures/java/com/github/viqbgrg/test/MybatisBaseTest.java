package com.github.viqbgrg.test;


import com.github.viqbgrg.base.MybatisBase;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;

public abstract class MybatisBaseTest<T> {
    protected static SqlSession sqlSession;

    @BeforeAll
    static void setSqlSession() throws IOException {
        MybatisBase mybatisBase = new MybatisBase();
        SqlSessionFactory sqlSessionFactory = mybatisBase.createSqlSessionFactory();
        sqlSession = sqlSessionFactory.openSession();
    }

    protected T getMapper() {
        Class<T> actualTypeArgument = (Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return sqlSession.getMapper(actualTypeArgument);
    }

}