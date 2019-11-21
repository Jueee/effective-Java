package com.jueee.item26;

import java.util.ArrayList;
import java.util.List;

public class Item26Example03 {
    
    // Fails at runtime - unsafeAdd method uses a raw type (List)!
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        
        unsafeAdd(strings, "42");    
        
        String s = strings.get(0); 
        System.out.println(s);
    }

    private static void unsafeAdd(List<String> list, String o) {
        list.add(o);
    }

}
