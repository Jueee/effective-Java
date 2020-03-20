package com.jueee.item32;

import java.util.ArrayList;
import java.util.List;

public class Item32Example03 {


    // Safe method with a generic varargs parameter
    @SafeVarargs
    static <T> List<T> flatten(List<? extends T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists)
            result.addAll(list);
        return result;
    }


    
    public static void main(String[] args) {
        List<String> audience = flatten(List.of("Good", "Fast", "Cheap"));
        System.out.println(audience);
    }

}
