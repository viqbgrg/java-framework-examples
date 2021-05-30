package com.github.viqbgrg.mybatis.typehandler;

import com.github.viqbgrg.mybatis.typehandler.entity.UserJson;
import com.github.viqbgrg.mybatis.typehandler.mapper.UserJsonMapper;
import com.github.viqbgrg.test.MybatisBaseTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class UserJsonMapperTest extends MybatisBaseTest<UserJsonMapper> {

    @Test
    void insert() {
        UserJsonMapper mapper = getMapper();
        UserJson userJson = new UserJson();
        userJson.setId(3);
        userJson.setName("小明");
        String[] bookNames = {"西游记","红楼梦"};
        userJson.setBookNames(Arrays.asList(bookNames));
        int insert = mapper.insert(userJson);
        assertThat(insert).isGreaterThan(0);

    }

    @Test
    void selectAll() {
        UserJsonMapper mapper = getMapper();
        List<UserJson> userJsons = mapper.selectAll();
        assertThat(userJsons).isNotEmpty();
    }
}