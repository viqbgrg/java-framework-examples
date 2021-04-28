package com.viqbgrg.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.viqbgrg.mybatisplus.entity.Book;
import com.viqbgrg.mybatisplus.mapper.BookMapper;
import com.viqbgrg.mybatisplus.service.IBookService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author bing
 * @since 2021-04-23
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

}
