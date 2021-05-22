package com.github.viqbgrg.base;

import org.apache.ibatis.binding.MapperRegistry;
import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

/**
 * @author hhj
 */
public class MybatisBase {
    private String schemaName;
    private String dataName;
    private String mybatisConfigName;

    public MybatisBase(String schemaName, String dataName, String mybatisConfigName) {
        this.schemaName = schemaName;
        this.dataName = dataName;
        this.mybatisConfigName = mybatisConfigName;
    }

    public MybatisBase() {
        this.schemaName = "schema.sql";
        this.dataName = "data.sql";
        this.mybatisConfigName = "mybatis-config.xml";
    }

    public SqlSessionFactory createSqlSessionFactory() throws IOException {
        final Configuration targetConfiguration;
        InputStream inputStream = Resources.getResourceAsStream(mybatisConfigName);
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(inputStream);
        targetConfiguration = xmlConfigBuilder.parse();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, createPooledDataSource());
        targetConfiguration.setEnvironment(environment);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(targetConfiguration);
        return sqlSessionFactory;
    }

    public PooledDataSource createPooledDataSource() throws IOException {
        PooledDataSource ds = new PooledDataSource();
        ds.setDriver("org.h2.Driver");
        ds.setUrl("jdbc:h2:mem:test;MODE=MySQL;DATABASE_TO_LOWER=TRUE;INIT=RUNSCRIPT FROM '" + Resources.getResourceURL(this.schemaName).getPath() + "'\\;RUNSCRIPT FROM '" + Resources.getResourceURL(this.dataName).getPath() + "'");
        ds.setUsername("");
        ds.setPassword("");
        return ds;
    }


    public UnpooledDataSource createUnpooledDataSource(String resource) throws IOException {
        Properties props = Resources.getResourceAsProperties(resource);
        UnpooledDataSource ds = new UnpooledDataSource();
        ds.setDriver(props.getProperty("driver"));
        ds.setUrl(props.getProperty("url"));
        ds.setUsername(props.getProperty("username"));
        ds.setPassword(props.getProperty("password"));
        return ds;
    }

    public PooledDataSource createPooledDataSource(String resource) throws IOException {
        Properties props = Resources.getResourceAsProperties(resource);
        PooledDataSource ds = new PooledDataSource();
        ds.setDriver(props.getProperty("driver"));
        ds.setUrl(props.getProperty("url"));
        ds.setUsername(props.getProperty("username"));
        ds.setPassword(props.getProperty("password"));
        return ds;
    }


}
