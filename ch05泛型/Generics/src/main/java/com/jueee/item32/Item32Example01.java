package com.jueee.item32;

import java.util.Arrays;
import java.util.List;

public class Item32Example01 {

    // Mixing generics and varargs can violate type safety!
    static void dangerous(List<String>... stringLists) {
        List<Integer> intList = List.of(42);
        Object[] objects = stringLists;
        objects[0] = intList;             // Heap pollution
        String s = stringLists[0].get(0); // ClassCastException
    }

    public static void main(String[] args) {
        dangerous(Arrays.asList("a"));
    }
}
