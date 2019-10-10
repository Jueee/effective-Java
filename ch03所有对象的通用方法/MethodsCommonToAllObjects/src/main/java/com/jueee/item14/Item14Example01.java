package com.jueee.item14;

import java.util.Set;
import java.util.TreeSet;

public class Item14Example01 {

    public static void main(String[] args) {
        Set<String> s = new TreeSet<>();
        s.add("c");
        s.add("a");
        s.add("b");
        s.add("e");
        s.add("a");
        s.add("d");
        System.out.println(s);  // [a, b, c, d, e]
    }
}
