package com.viqbgrg.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.viqbgrg.mybatisplus.entity.Student;
import com.viqbgrg.mybatisplus.mapper.StudentMapper;
import com.viqbgrg.mybatisplus.service.IStudentService;
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
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
