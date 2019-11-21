package com.jueee.item26;

import java.util.ArrayList;
import java.util.List;

public class Item26Example02 {
    
    // Fails at runtime - unsafeAdd method uses a raw type (List)!
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        
        // The method unsafeAdd(List<Object>, Object) in the type Item26Example02 is not applicable for the arguments (List<String>, Integer)
//      unsafeAdd(strings, Integer.valueOf(42));    
        
        String s = strings.get(0); 
        System.out.println(s);
    }

    private static void unsafeAdd(List<Object> list, Object o) {
        list.add(o);
    }

}
