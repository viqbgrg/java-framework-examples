package com.github.viqbgrg.mybatis.plus.dynamic.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.annotation.Master;
import com.baomidou.dynamic.datasource.annotation.Slave;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.viqbgrg.mybatis.plus.dynamic.entity.Book;
import com.github.viqbgrg.mybatis.plus.dynamic.mapper.BookMapper;
import com.github.viqbgrg.mybatis.plus.dynamic.service.IBookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hhj
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {
    @Override
    @Master
    public List<Book> listMaster() {
        return this.list();
    }

    @Override
    @Slave
    public List<Book> listSlave() {
        return this.list();
    }

    @Override
    @Slave
    public boolean saveOrUpdateBatchDs(ArrayList<Book> books) {
        return this.saveOrUpdateBatch(books);
    }

    @Override
    @Slave
    public boolean saveSlave(Book book) {
        return this.save(book);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void transactional() {
        ArrayList<Book> books1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            // 数据库已经存在了二条
            book.setId(i + 2);
            book.setName(String.valueOf(i));
            books1.add(book);
        }
        int i = 1/0;
        List<Book> list = this.list();
        Book book1 = list.get(0);
        book1.setName("嘿嘿");
        this.updateById(book1);
        this.saveOrUpdateBatch(books1);
    }
}
