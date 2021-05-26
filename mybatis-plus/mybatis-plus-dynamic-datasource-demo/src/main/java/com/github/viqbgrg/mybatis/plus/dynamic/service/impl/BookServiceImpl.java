package com.github.viqbgrg.mybatis.plus.dynamic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.viqbgrg.mybatis.plus.dynamic.entity.Book;
import com.github.viqbgrg.mybatis.plus.dynamic.mapper.BookMapper;
import com.github.viqbgrg.mybatis.plus.dynamic.service.IBookService;
import org.springframework.stereotype.Service;

/**
 * @author hhj
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {
}
