package com.github.viqbgrg.mybatis.sqlmap.entity;

import com.github.viqbgrg.mybatis.sqlmap.mapper.UserBookMapper;
import com.github.viqbgrg.test.MybatisBaseTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class UserBookMapperTest extends MybatisBaseTest {
    @Test
    void selectAll() {
        UserBookMapper mapper = this.sqlSession.getMapper(UserBookMapper.class);
        List<UserBook> userBooks = mapper.selectAll();
        assertThat(userBooks).isNotNull();
        assertThat(userBooks.size()).isGreaterThanOrEqualTo(1);
        assertThat(userBooks.get(0).getBook()).isNotNull();
    }
}