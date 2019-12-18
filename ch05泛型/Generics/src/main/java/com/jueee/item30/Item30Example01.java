package com.jueee.item30;

import java.util.HashSet;
import java.util.Set;

public class Item30Example01 {
    
    // Uses raw types - unacceptable!
    public static Set union1(Set s1, Set s2) {
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }
    
    // Generic method
    public static <E> Set<E> union2(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    // Simple program to exercise generic method
    public static void main(String[] args) {
        Set<String> guys = Set.of("Tom", "Dick", "Harry");
        Set<String> stooges = Set.of("Larry", "Moe", "Curly");
        
        Set<String> aflCio1 = union1(guys, stooges);
        System.out.println(aflCio1);
        
        Set<String> aflCio2 = union2(guys, stooges);
        System.out.println(aflCio2);
    }

}
