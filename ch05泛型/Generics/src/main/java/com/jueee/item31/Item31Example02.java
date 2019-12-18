package com.jueee.item31;

import java.util.Arrays;
import java.util.List;

public class Item31Example02 {

    public static void swap(List<?> list, int i, int j) {
        swapHelper(list, i, j);
    }

    // Private helper method for wildcard capture
    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }



    public static void main(String[] args) {
        List<String> list = Arrays.asList("a","b","c","d","e");
        System.out.println(list);   // [a, b, c, d, e]
        swap(list, 1, 3);
        System.out.println(list);   // [a, d, c, b, e]
    }
}
