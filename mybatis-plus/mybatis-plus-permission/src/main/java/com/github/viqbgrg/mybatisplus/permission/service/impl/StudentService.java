package com.github.viqbgrg.mybatisplus.permission.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.viqbgrg.mybatisplus.permission.entity.Student;
import com.github.viqbgrg.mybatisplus.permission.mapper.StudentMapper;
import com.github.viqbgrg.mybatisplus.permission.service.IStudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService extends ServiceImpl<StudentMapper, Student> implements IStudentService {
    @Override
    public List<Student> getStudentByName() {
        return this.baseMapper.getStudentByName();
    }
}
