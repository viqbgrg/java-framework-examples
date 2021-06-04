package com.github.viqbgrg.mybatis.plus.dynamic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.viqbgrg.mybatis.plus.dynamic.entity.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hhj
 */
public interface IBookService extends IService<Book> {
    List<Book> listMaster();
    List<Book> listSlave();
    boolean saveOrUpdateBatchDs(ArrayList<Book> books);

    boolean saveSlave(Book book);

    void transactional();
}
