package com.github.viqbgrg.shirobootdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.viqbgrg.shirobootdemo.domain.dto.UserSignInDto;
import com.github.viqbgrg.shirobootdemo.entity.User;
import com.github.viqbgrg.shirobootdemo.mapper.UserMapper;
import com.github.viqbgrg.shirobootdemo.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author hhj
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public void signIn(UserSignInDto userSignInDto) {
        User user = new User();
        user.setEmail(userSignInDto.getEmail());
        user.setPassword(userSignInDto.getPassword());
        this.save(user);
    }
}
