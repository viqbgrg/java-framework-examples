package com.github.viqbgrg.plugins.mapper;

import com.github.viqbgrg.plugins.entity.UserBook;

public interface UserMapper {
    UserBook selectUser(long id);
}
