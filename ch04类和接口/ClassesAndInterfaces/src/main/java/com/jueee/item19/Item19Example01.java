package com.jueee.item19;

import java.time.Instant;

/**
 * 构造方法绝不能直接或间接调用可重写的方法
 * @author hzweiyongqiang
 */
public final class Item19Example01 extends Super {
    // Blank final, set by constructor
    private final Instant instant;

    Item19Example01() {
        instant = Instant.now();
    }

    // Overriding method invoked by superclass constructor
    @Override
    public void overrideMe() {
        System.out.println(instant);
    }

    public static void main(String[] args) {
        Item19Example01 sub = new Item19Example01();
        sub.overrideMe();
    }
}

class Super {
    // Broken - constructor invokes an overridable method
    public Super() {
        overrideMe();
    }

    public void overrideMe() {}
}
