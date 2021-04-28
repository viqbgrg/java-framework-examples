package com.viqbgrg.mybatisplus.mapper;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import com.viqbgrg.mybatisplus.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@MybatisPlusTest
class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    void getStudentBook() {
        Student studentBook = studentMapper.getStudentBook("1");
        assertThat(studentBook.getId()).isNotNull();
        assertThat(studentBook).isNotNull();
    }
}