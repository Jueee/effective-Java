package com.jueee.item28;

public class Item28Example01 {

    public static void main(String[] args) {
        // Fails at runtime!
        Object[] objectArray = new Long[1];
        objectArray[0] = "I don't fit in"; // 抛出 ArrayStoreException 异常
        System.out.println(objectArray[0]);
        
        // Won't compile!
//      List<Object> ol = new ArrayList<Long>(); // Incompatible types
//      ol.add("I don't fit in");
    }
}
