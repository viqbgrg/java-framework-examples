package com.github.viqbgrg.mybatis.plus.shardingsphere.mapper;

import com.baomidou.dynamic.datasource.annotation.Master;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.viqbgrg.mybatis.plus.shardingsphere.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//@MybatisPlusTest
//@Import({MybatisPlusConfig.class, DynamicDataSourceAutoConfiguration.class})
@SpringBootTest
class BookMapperTest {
    @Autowired
    private BookMapper mapper;

    @Test
    void selectAll() {
        List<Book> books = mapper.selectList(Wrappers.emptyWrapper());
        assertThat(books).isNotNull();
    }

    @Test
    @Master
    void selectAllMaster() {
        List<Book> books = mapper.selectList(Wrappers.emptyWrapper());
        assertThat(books).isNotNull();
    }
}