package com.github.viqbgrg.mybatis.typehandler;

import com.github.viqbgrg.mybatis.typehandler.entity.UserJson;
import com.github.viqbgrg.mybatis.typehandler.mapper.UserJsonMapper;
import com.github.viqbgrg.test.MybatisBaseTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class UserJsonMapperTest extends MybatisBaseTest<UserJsonMapper> {

    @Test
    void inserAndSelectAll() {
        UserJsonMapper mapper = getMapper();
        UserJson userJson = new UserJson();
        userJson.setId(3);
        userJson.setName("小明");
//        userJson.setBook_names(Arrays.asList("西游记","红楼梦"));
        mapper.insert(userJson);
        UserJson userJson1 = mapper.selectAll();
//        assertThat(userJson1.getBook_names()).isNotEmpty();
    }
}