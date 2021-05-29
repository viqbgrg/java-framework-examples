package com.github.viqbgrg.mybatis.typehandler.mapper;

import com.github.viqbgrg.mybatis.typehandler.entity.UserJson;

public interface UserJsonMapper {
    int insert(UserJson userJson);
    UserJson selectAll();
}
