package com.github.viqbgrg.shirobootdemo.service.impl;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.viqbgrg.shirobootdemo.domain.dto.UserSignInDto;
import com.github.viqbgrg.shirobootdemo.entity.User;
import com.github.viqbgrg.shirobootdemo.exception.UsernameExistException;
import com.github.viqbgrg.shirobootdemo.mapper.UserMapper;
import com.github.viqbgrg.shirobootdemo.service.IUserService;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hhj
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public void signIn(UserSignInDto userSignInDto) {
        List<User> userList = list(Wrappers.lambdaQuery(User.class).eq(User::getEmail, userSignInDto.getEmail()));
        if (ObjectUtils.isNotEmpty(userList)) {
            throw new UsernameExistException(userSignInDto.getEmail());
        }
        User user = new User();
        user.setEmail(userSignInDto.getEmail());
        String password = userSignInDto.getPassword();
        DefaultPasswordService defaultPasswordService = new DefaultPasswordService();
        String s = defaultPasswordService.encryptPassword(password);
        user.setPassword(s);
        this.save(user);
    }
}
