package com.viqbgrg.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.viqbgrg.mybatisplus.entity.User;
import com.viqbgrg.mybatisplus.mapper.UserMapper;
import com.viqbgrg.mybatisplus.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bing
 * @since 2021-04-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
