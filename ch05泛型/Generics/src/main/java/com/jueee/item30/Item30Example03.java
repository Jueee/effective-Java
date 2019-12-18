package com.jueee.item30;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Item30Example03 {

    // Returns max value in a collection - uses recursive type bound
    public static <E extends Comparable<E>> E max(Collection<E> c) {
        if (c.isEmpty()) {
            throw new IllegalArgumentException("Empty collection");
        }
        E result = null;
        for (E e : c) {
            if (result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(11,22,43,34,35,56,25);
        System.out.println(max(integers));
    }
}
