package com.jueee.item20;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

public class Item20Example02 {

    static List<Integer> intArrayAsList(int[] a) {
        Objects.requireNonNull(a);
        // The diamond operator is only legal here in Java 9 and later
        // If you're using an earlier release, specify <Integer>
        return new AbstractList<Integer>() {
            @Override
            public Integer get(int i) {
                return a[i]; // Autoboxing
            }

            @Override
            public Integer set(int i, Integer val) {
                int oldVal = a[i];
                a[i] = val; // Auto-unboxing
                return oldVal; // Autoboxing
            }

            @Override
            public int size() {
                return a.length;
            }
        };

    }

}
