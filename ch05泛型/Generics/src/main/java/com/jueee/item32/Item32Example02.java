package com.jueee.item32;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

public class Item32Example02 {

    static <T> T[] pickTwo(T a, T b, T c) {
        Collection<T> collection = new ArrayList<T>();
        switch(ThreadLocalRandom.current().nextInt(3)) {
          case 0: return toArray(a, b);
          case 1: return toArray(a, c);
          case 2: return toArray(b, c);
        }
        throw new AssertionError(); // Can't get here
    }
    
    // UNSAFE - Exposes a reference to its generic parameter array!
    static <T> T[] toArray(T... args) {
        return args;
    }
    
    public static void main(String[] args) {
        String[] attributes = pickTwo("Good", "Fast", "Cheap");
        System.out.println(attributes);
    }
}
