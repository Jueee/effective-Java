package com.jueee.item26;

import java.util.HashSet;
import java.util.Set;

public class Item26Example06 {
    
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("test");
        instanceofObject(set);
        instanceofObjectWarn(set);
    }

    // 使用泛型类型的 instanceof 运算符的首选方法
    // 一旦确定 o 对象是一个 Set，则必须将其转换为通配符 Set<?>，而不是原始类型 Set。 
    // 这是一个强制转换，所以不会导致编译器警告。
    private static void instanceofObject(Object o) {
        if (o instanceof Set) {       // Raw type
            Set<?> s = (Set<?>) o;    // Wildcard type
            System.out.println(s);
        } else {
            System.out.println("worry type.");
        }
    }

    private static void instanceofObjectWarn(Object o) {
        if (o instanceof Set) {     
            Set s = (Set) o;    // 编译器警告：Set is a raw type. References to generic type Set<E> should be parameterized
            System.out.println(s);
        } else {
            System.out.println("worry type.");
        }
    }


}
