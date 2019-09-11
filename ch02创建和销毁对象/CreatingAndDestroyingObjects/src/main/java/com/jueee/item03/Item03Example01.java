package com.jueee.item03;

public class Item03Example01 {

    public static void main(String[] args) {
        Elvis1 elvis11 = Elvis1.INSTANCE;
        elvis11.leaveTheBuilding();
        Elvis1 elvis12 = Elvis1.INSTANCE;
        elvis12.leaveTheBuilding();
        Elvis1 elvis13 = Elvis1.INSTANCE;
        elvis13.leaveTheBuilding();
    }
}

// 成员是final修饰的属性
class Elvis1 {
    
    public static final Elvis1 INSTANCE = new Elvis1();

    // 私有构造方法只调用一次，来初始化公共静态 final Elvis1.INSTANCE属性。
    private Elvis1() {}

    public void leaveTheBuilding() {
        System.out.println(INSTANCE);
    }
}