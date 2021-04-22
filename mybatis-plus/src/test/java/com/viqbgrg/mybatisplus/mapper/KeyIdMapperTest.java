package com.viqbgrg.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import com.viqbgrg.mybatisplus.entity.KeyId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@MybatisPlusTest
class KeyIdMapperTest {
    @Autowired
    private KeyIdMapper mapper;

    @Test
    void addKey() {
        KeyId keyId = new KeyId();
        int insert = mapper.insert(keyId);
        List<KeyId> keyIds = mapper.selectList(Wrappers.emptyWrapper());
        keyIds.forEach(item -> {
            System.out.println(item.getId());
        });
    }
}