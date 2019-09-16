package com.jueee.item04;

public class Item04Example01 {

}

// 不可实例化的程序类
class UtilityClass {
    // 禁止默认构造函数以实现非实例化
    private UtilityClass() {
        throw new AssertionError();
    }
}