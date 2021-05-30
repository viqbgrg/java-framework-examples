package com.github.viqbgrg.mybatis.plus.dynamic.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.annotation.Master;
import com.baomidou.dynamic.datasource.annotation.Slave;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.viqbgrg.mybatis.plus.dynamic.entity.Book;
import com.github.viqbgrg.mybatis.plus.dynamic.mapper.BookMapper;
import com.github.viqbgrg.mybatis.plus.dynamic.service.IBookService;
import org.springframework.stereotype.Service;

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
}
