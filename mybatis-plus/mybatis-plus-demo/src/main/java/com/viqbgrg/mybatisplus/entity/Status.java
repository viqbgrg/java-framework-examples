package com.viqbgrg.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @author hhj
 */
public enum Status {
    OPEN(0, "开放"), CLOSE(1, "关闭");

    @EnumValue
    private final int code;
    private final String title;

    Status(int code, String title) {
        this.code = code;
        this.title = title;
    }

    public int getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }
}
