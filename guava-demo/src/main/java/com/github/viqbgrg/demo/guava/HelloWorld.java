package com.github.viqbgrg.demo.guava;

import com.google.common.base.Optional;
import org.junit.jupiter.api.Test;

public class HelloWorld {

    @Test
    void firstTest() {
        Optional<Integer> possible = Optional.absent();
        possible = Optional.of(5);
        System.out.println(possible.get());
    }
}
