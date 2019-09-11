package com.jueee.item03;

public class Item03Example03 {

    public static void main(String[] args) {
        Elvis3 elvis21 = Elvis3.INSTANCE;
        elvis21.leaveTheBuilding();
        Elvis3 elvis22 = Elvis3.INSTANCE;
        elvis22.leaveTheBuilding();
        Elvis3 elvis23 = Elvis3.INSTANCE;
        elvis23.leaveTheBuilding();
    }
}

// 声明单一元素的枚举类
enum Elvis3 {
    INSTANCE;
    
    public void leaveTheBuilding() {
        System.out.println(INSTANCE);
    }
}