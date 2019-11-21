package com.jueee.item27;

import java.util.HashSet;
import java.util.Set;

public class Item27Example01 {

    public static void main(String[] args) {
        
        // 警告：HashSet是原始类型。 泛型类型HashSet <E>的引用应参数化。
        new HashSet(); 

        // 进行指示修正，让警告消失。
        // 请注意，实际上并不需要指定类型参数，只是为了表明它与 Java 7 中引入的钻石运算符（「<>」）一同出现。
        new HashSet<>(); 
        
        // 使用 SuppressWarnings 注解声明单个局部变量
        @SuppressWarnings({"rawtypes", "unchecked"})
        Set<String> set3 = new HashSet(); 
        System.out.println(set3);
    }
}
