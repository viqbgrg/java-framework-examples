package com.github.viqbgrg.mybatisdemo;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

class MybatisConfigTest {

    @Test
    void createPooledDataSource() throws SQLException {
        PooledDataSource pooledDataSource = MybatisConfig.createPooledDataSource();
        Connection connection = pooledDataSource.getConnection();
        assertThat(connection).isNotNull();
    }
}