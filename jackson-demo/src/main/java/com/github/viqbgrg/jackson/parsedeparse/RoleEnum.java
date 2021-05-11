package com.github.viqbgrg.jackson.parsedeparse;

public enum RoleEnum {
    ADMIN(0), USER(1);
    private int code;

    RoleEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
