package com.jueee.item10;

import java.util.Objects;

// 违反对称性
public class Item10Example01 {

    public static void main(String[] args) {
        CaseInsensitiveString01 cis = new CaseInsensitiveString01("Polish");
        String s = "polish";

        System.out.println(cis.equals(s)); // true
        System.out.println(s.equals(cis)); // false
        

        CaseInsensitiveString01 cis2 = new CaseInsensitiveString01("polish");
        System.out.println(cis.equals(cis2)); // true
    }
}

// 实现了不区分大小写的字符串。字符串被 toString 保存，但在 equals 比较中被忽略
class CaseInsensitiveString01 {
    private final String s;

    public CaseInsensitiveString01(String s) {
        this.s = Objects.requireNonNull(s);
    }

    // Broken - violates symmetry!
    @Override
    public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString01)
            return s.equalsIgnoreCase(((CaseInsensitiveString01)o).s);
        if (o instanceof String) // One-way interoperability!
            return s.equalsIgnoreCase((String)o);
        return false;
    }
}