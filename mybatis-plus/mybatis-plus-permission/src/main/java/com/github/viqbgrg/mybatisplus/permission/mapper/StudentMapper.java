package com.github.viqbgrg.mybatisplus.permission.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.viqbgrg.mybatisplus.permission.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    List<Student> getStudentByName();
}
