package com.github.viqbgrg.mybatis.plus.dynamic.service.impl;

import com.github.viqbgrg.mybatis.plus.dynamic.entity.Book;
import com.github.viqbgrg.mybatis.plus.dynamic.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class BookServiceImplTest {
    @Autowired
    private IBookService bookService;

    @Test
    void saveOrUpdateBatchTest() {
        ArrayList<Book> books1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            // 数据库已经存在了二条
            book.setId(i + 2);
            book.setName(String.valueOf(i));
            books1.add(book);
        }
        bookService.saveOrUpdateBatch(books1);
    }
}