package com.github.viqbgrg.mybatisdemo.mapper;

import com.github.viqbgrg.mybatisdemo.entity.User;

public interface UserMapper {
    User selectUser(long id);
}
