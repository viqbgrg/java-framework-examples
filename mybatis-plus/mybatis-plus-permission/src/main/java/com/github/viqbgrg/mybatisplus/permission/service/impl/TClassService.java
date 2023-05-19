package com.github.viqbgrg.mybatisplus.permission.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.viqbgrg.mybatisplus.permission.entity.Student;
import com.github.viqbgrg.mybatisplus.permission.entity.TClass;
import com.github.viqbgrg.mybatisplus.permission.mapper.StudentMapper;
import com.github.viqbgrg.mybatisplus.permission.mapper.TClassMapper;
import com.github.viqbgrg.mybatisplus.permission.service.IStudentService;
import com.github.viqbgrg.mybatisplus.permission.service.ITClassService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TClassService extends ServiceImpl<TClassMapper, TClass> implements ITClassService {
}
