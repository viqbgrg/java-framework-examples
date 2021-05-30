package com.github.viqbgrg.mybatis.plus.dynamic.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.annotation.Master;
import com.baomidou.dynamic.datasource.annotation.Slave;
import com.github.viqbgrg.mybatis.plus.dynamic.entity.Book;
import com.github.viqbgrg.mybatis.plus.dynamic.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
        bookService.saveOrUpdateBatchDs(books1);
    }

    @Test
    void selectAll() {
        List<Book> list = bookService.listMaster();
        assertThat(list).isNotEmpty();
        assertThat(list.get(0).getName()).isEqualTo("西游记");
    }
    @Test
    void selectAllSlave() {
        List<Book> list = bookService.listSlave();
        assertThat(list).isNotEmpty();
        assertThat(list.get(0).getName()).isEqualTo("西游记11");
    }

    /**
     * 在测试方法上面写注释无效
     */
    @Test
    @DS("111111")
    void selectAllSlaveTestAnno() {
        List<Book> list = bookService.list();
        assertThat(list).isNotEmpty();
        assertThat(list.get(0).getName()).isEqualTo("西游记");
    }

    @Test
    void saveSlaveTest() {
        Book book = new Book();
        book.setId(5);
        book.setName("哈哈");
        bookService.saveSlave(book);
    }
}