package com.github.viqbgrg.mybatis.typehandler.mapper;

import com.github.viqbgrg.mybatis.typehandler.entity.UserJson;

import java.util.List;

public interface UserJsonMapper {
    int insert(UserJson userJson);
    UserJson[] selectAll();
}
