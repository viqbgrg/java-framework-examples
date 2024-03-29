package com.github.viqbgrg.shirobootdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.viqbgrg.shirobootdemo.domain.dto.UserLoginDto;
import com.github.viqbgrg.shirobootdemo.domain.dto.UserSignInDto;
import com.github.viqbgrg.shirobootdemo.entity.User;

/**
 * @author hhj
 */
public interface IUserService extends IService<User> {
    void signIn(UserSignInDto userSignInDto);

    User login(UserLoginDto userLoginDto);
}
