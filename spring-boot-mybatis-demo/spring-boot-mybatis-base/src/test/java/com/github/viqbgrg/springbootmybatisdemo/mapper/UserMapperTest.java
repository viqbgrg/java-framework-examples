package com.github.viqbgrg.springbootmybatisdemo.mapper;
import com.github.viqbgrg.springbootmybatisdemo.domain.Car;
import com.github.viqbgrg.springbootmybatisdemo.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@MybatisTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @BeforeAll
    void testSaveJsonObject() {
        User user = new User();
        user.setName("123");
        int[] income = {1, 2, 3};
//        user.setIncome(income);
        Car car = new Car();
        car.setColor("red");
        car.setName("奔驰");
        user.setCar(car);
        userMapper.insertUser(user);
    }
    /**
     * 把json数组转换成List
     */
    @Test
    void testJsonArrayToList() {
        List<User> users = userMapper.selectAll();
        User user = users.get(0);
        Assertions.assertThat(user.getIncome()).isNotEmpty();
    }
}
