package com.jueee.item01;

// 考虑使用静态工厂方法替代构造方法
public class Item01Example01 {

    public static void main(String[] args) {
        // 传统构造器
        Item01Test1 test1 = new Item01Test1("true");
        System.out.println(test1.getParam());
        
        // 使用静态工厂方法替代构造方法
        Item01Test2 test2 = Item01Test2.valueOf("false");
        System.out.println(test2.getParam());
    }
}

class Item01Test1 {
    
    private String param;
    
    public Item01Test1(String param) {
        this.param = param;
    }
    
    public String getParam() {
        return param;
    }
}

class Item01Test2 {
    
    private static String param;
    
    private Item01Test2() {}
    
    public static Item01Test2 valueOf(String paramData) {
        param = paramData;
        return new Item01Test2();
    }
    
    public String getParam() {
        return param;
    }
}