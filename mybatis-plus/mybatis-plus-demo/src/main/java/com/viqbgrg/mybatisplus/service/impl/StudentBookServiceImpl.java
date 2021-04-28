package com.viqbgrg.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.viqbgrg.mybatisplus.entity.StudentBook;
import com.viqbgrg.mybatisplus.mapper.StudentBookMapper;
import com.viqbgrg.mybatisplus.service.IStudentBookService;
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
public class StudentBookServiceImpl extends ServiceImpl<StudentBookMapper, StudentBook> implements IStudentBookService {

}
