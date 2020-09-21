package com.github.viqbgrg;

import lombok.Data;

@Data
public class CircleA {
    private CircleB circleB;

    public CircleA() {
    }

    public CircleA(CircleB circleB) {
        this.circleB = circleB;
    }
}
