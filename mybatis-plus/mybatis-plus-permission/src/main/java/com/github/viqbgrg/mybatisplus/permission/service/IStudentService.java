package com.github.viqbgrg.mybatisplus.permission.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.viqbgrg.mybatisplus.permission.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStudentService extends IService<Student> {
    List<Student> getStudentByName();
}
