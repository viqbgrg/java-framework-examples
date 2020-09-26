package com.github.viqbgrg.idref;

import lombok.Data;

@Data
public class Bean2 {
    private String beanName;

    public void test() {
        System.out.println(beanName);
    }
}
