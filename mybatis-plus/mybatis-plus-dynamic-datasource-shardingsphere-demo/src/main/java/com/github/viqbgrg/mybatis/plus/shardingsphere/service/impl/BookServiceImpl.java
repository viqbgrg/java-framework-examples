package com.github.viqbgrg.mybatis.plus.shardingsphere.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.viqbgrg.mybatis.plus.shardingsphere.entity.Book;
import com.github.viqbgrg.mybatis.plus.shardingsphere.mapper.BookMapper;
import com.github.viqbgrg.mybatis.plus.shardingsphere.service.IBookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hhj
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {
    @Override
    public List<Book> listMaster() {
        return this.list();
    }

    @Override
    public List<Book> listSlave() {
        return this.list();
    }

    @Override
    public boolean saveOrUpdateBatchDs(ArrayList<Book> books) {
        return this.saveOrUpdateBatch(books);
    }

    @Override
    public boolean saveSlave(Book book) {
        return this.save(book);
    }

    @Override
    public void transactional() {
        ArrayList<Book> books1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            // 数据库已经存在了二条
            book.setId(i + 2);
            book.setName(String.valueOf(i));
            books1.add(book);
        }
        List<Book> list = this.list();
        List<Book> list1 = this.list();
        List<Book> list12 = this.list();
        List<Book> list13 = this.list();
        Book book1 = list.get(0);
        book1.setName("嘿嘿");
        this.updateById(book1);
        this.saveOrUpdateBatch(books1);
    }
}
