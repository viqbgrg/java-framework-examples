package com.github.viqbgrg.mybatis.plus.dynamic.controller;

import com.github.viqbgrg.mybatis.plus.dynamic.service.IBookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bing
 */
@RestController
@RequestMapping("")
public class HelloWorldController {

    private IBookService bookService;

    public HelloWorldController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public void test() {
        bookService.transactional();
    }
}
