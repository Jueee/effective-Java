package com.jueee.item03;

public class Item03Example02 {

    public static void main(String[] args) {
        Elvis2 elvis21 = Elvis2.getInstance();
        elvis21.leaveTheBuilding();
        Elvis2 elvis22 = Elvis2.getInstance();
        elvis22.leaveTheBuilding();
        Elvis2 elvis23 = Elvis2.getInstance();
        elvis23.leaveTheBuilding();
    }
}

// 公共成员是一个静态的工厂方法
class Elvis2 {

    private static final Elvis2 INSTANCE = new Elvis2();

    private Elvis2() {}

    public static Elvis2 getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
        System.out.println(INSTANCE);
    }
}