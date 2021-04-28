package com.github.viqbgrg.plugins.mapper;

import com.github.viqbgrg.plugins.entity.User;

public interface UserMapper {
    User selectUser(long id);
}
