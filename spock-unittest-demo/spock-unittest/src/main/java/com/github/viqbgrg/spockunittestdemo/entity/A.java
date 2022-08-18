package com.github.viqbgrg.spockunittestdemo.entity;

import lombok.Data;

public class A<T> {
    private T Item;

    public final T getItem() {
        return Item;
    }

    public final void setItem(T item) {
        Item = item;
    }
}
