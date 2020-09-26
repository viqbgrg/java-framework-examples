package com.github.viqbgrg;

import lombok.Data;

@Data
public class CircleB {
    private CircleA circleA;

    public CircleB() {
    }

    public CircleB(CircleA circleA) {
        this.circleA = circleA;
    }

    @Override
    public String toString() {
        return "CircleB{" +
                "circleA=" + circleA +
                '}';
    }
}
