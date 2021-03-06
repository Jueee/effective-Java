package com.jueee.item26;

import java.util.ArrayList;
import java.util.List;

public class Item26Example01 {
    
    // Fails at runtime - unsafeAdd method uses a raw type (List)!
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42));
        String s = strings.get(0); //  java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        System.out.println(s);
    }

    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }

}
