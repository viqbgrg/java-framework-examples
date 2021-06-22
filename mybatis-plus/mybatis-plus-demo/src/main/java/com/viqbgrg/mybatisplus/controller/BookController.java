package com.viqbgrg.mybatisplus.controller;


import com.viqbgrg.mybatisplus.entity.Book;
import com.viqbgrg.mybatisplus.service.IBookService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author bing
 * @since 2021-04-23
 */
@RestController
@RequestMapping("/book")
public class BookController {
    private IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("add")
    public String add() {
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setId(Long.valueOf(i+20));
            book.setName(String.valueOf(i+20));
            books.add(book);
        }
        this.bookService.saveBatch(books);
        Book book = new Book();
        book.setId(Long.valueOf(31));
        book.setName(String.valueOf(11));
        this.bookService.save(book);
        int a = 1/0;
        System.out.println(a);
        return "SUCCESS";
    }

    @GetMapping("add1")
    @Transactional
    public String add1() {
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setId(Long.valueOf(i+20));
            book.setName(String.valueOf(i+20));
            books.add(book);
        }
        this.bookService.saveBatch(books);
        Book book = new Book();
        book.setId(Long.valueOf(31));
        book.setName(String.valueOf(11));
        this.bookService.save(book);
        int a = 1/0;
        System.out.println(a);
        return "SUCCESS";
    }

    @GetMapping("list")
    public List<Book> list() {
        return this.bookService.list();
    }
}
