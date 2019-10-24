package com.jueee.item18;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Item18Example03 {

    public static void main(String[] args) {
        InstrumentedSet<String> set = new InstrumentedSet<String>(new TreeSet<String>());
        set.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
        System.out.println(set.getAddCount());  // 3
        System.out.println(set);    // [Crackle, Pop, Snap]
        
        // 用于临时替换没有计数功能下使用的集合实例：
        Set<String> s = new HashSet<String>();
        s.add("a");
        s.add("b");
        s.add("a");
        InstrumentedSet<String> set2 = new InstrumentedSet<String>(s);
        System.out.println(set2.getAddCount());  // 3
        System.out.println(set2);    // [a, b]
    }
}
