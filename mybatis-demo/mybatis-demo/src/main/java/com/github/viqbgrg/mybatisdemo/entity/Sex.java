package com.github.viqbgrg.mybatisdemo.entity;

/**
 * @author viqbg
 */

public enum Sex {
    MAN(1, "男"),
    WOMAN(0, "女");
    private int code;
    private String sexType;
    Sex(int code, String sexType) {
        this.code = code;
        this.sexType = sexType;
    }

    @Override
    public String toString() {
        return sexType;
    }
}
