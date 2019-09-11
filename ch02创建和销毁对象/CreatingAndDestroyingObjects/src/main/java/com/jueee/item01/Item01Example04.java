package com.jueee.item01;

public class Item01Example04 {

    public static void main(String[] args) {
        Item01MyMap1<String,String> map1 = new Item01MyMap1<String,String>();
        System.out.println(map1.getClass().getName());
        
        Item01MyMap2<String,String> map2 = Item01MyMap2.newInstance();
        System.out.println(map2.getClass().getName());
    }
}


class Item01MyMap1<K,V>{
    
    public Item01MyMap1(){}
    
}

class Item01MyMap2<K,V>{
    
    private Item01MyMap2(){}
    
    public static <K, V> Item01MyMap2<K,V> newInstance(){
        return new Item01MyMap2<K,V>();
    }
}