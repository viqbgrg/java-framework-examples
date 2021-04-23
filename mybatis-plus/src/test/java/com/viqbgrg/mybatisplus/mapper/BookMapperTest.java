package com.viqbgrg.mybatisplus.mapper;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import com.viqbgrg.mybatisplus.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@MybatisPlusTest
class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    void getBooks() {
        List<Book> books = bookMapper.getBooks(1);
        assertThat(books).hasSize(2);
    }
}