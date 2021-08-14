package com.viqbgrg.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author hhj
 */
@RequiredArgsConstructor
@Getter
public enum EnumType implements IEnum<String> {

    OPEN( "OPEN", "开放"), CLOSE("CLOSE", "关闭");
    @EnumValue
    private final String value;
    private final String title;

    @Override
    public String getValue() {
        return value;
    }
}
