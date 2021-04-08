package com.github.viqbgrg.mybatisdemo;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author hhj
 */
public class MybatisConfig {
    public static SqlSessionFactory sqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    public static PooledDataSource createPooledDataSource() throws IOException {
        PooledDataSource ds = new PooledDataSource();
        ds.setDriver("org.h2.Driver");
        ds.setUrl("jdbc:h2:mem:test;MODE=MySQL;DATABASE_TO_LOWER=TRUE;INIT=RUNSCRIPT FROM 'src/main/resources/schema.sql'");
        ds.setUsername("");
        ds.setPassword("");
        return ds;
    }


}
