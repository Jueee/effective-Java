package com.jueee.item01;

// 静态工厂方法不会每次调用时都创建对象（单例模式）
public class Item01Example02 {

    public static void main(String[] args) {
        Item01Singleton singleton = Item01Singleton.getInstance();
        System.out.println(singleton.getClass().getName());
    }
}

class Item01Singleton {
    /*
     * 利用一个静态变量来记录Item01Singleton类的唯一实例
     */
    private static Item01Singleton uniqueInstance;
    /*
     * 声明为private，使得只有Item01Singleton类内才可以调用构造器
     */
    private Item01Singleton(){}
    /*
     * 通过该方法实例化对象，并返回这个实例
     */
    public static Item01Singleton getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new Item01Singleton();
        } 
        return uniqueInstance;
    }
}