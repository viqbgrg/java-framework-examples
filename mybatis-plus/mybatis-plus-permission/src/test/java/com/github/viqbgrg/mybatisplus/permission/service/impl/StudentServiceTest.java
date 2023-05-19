package com.github.viqbgrg.mybatisplus.permission.service.impl;

import com.github.viqbgrg.mybatisplus.permission.entity.Student;
import com.github.viqbgrg.mybatisplus.permission.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StudentServiceTest {
    @Autowired
    private IStudentService studentService;

    @Test
    public void list() {
        List<Student> list = studentService.list();
        assertEquals(list.size(), 2);
    }

}