package com.github.viqbgrg.jsqlparser;

import net.sf.jsqlparser.JSQLParserException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FirstDemoTest {
    static final FirstDemo firstdemo = new FirstDemo();
    @Test
    void parser() throws JSQLParserException {
        firstdemo.parser();
    }

    @Test
    void buildTest() throws JSQLParserException {
        String oldSql = "select * from user where user_id = 1";
        String newSql = "select * from " + oldSql + " where role_id = 1";
        String buildSqlString = firstdemo.build(oldSql);
        assertThat(buildSqlString).isNotBlank();
    }
}