package com.jueee.item10;

import java.util.Objects;

// 符合对称性
public class Item10Example02 {

    public static void main(String[] args) {
        CaseInsensitiveString02 cis = new CaseInsensitiveString02("Polish");
        String s = "polish";

        System.out.println(cis.equals(s)); // false
        System.out.println(s.equals(cis)); // false
        

        CaseInsensitiveString02 cis2 = new CaseInsensitiveString02("polish");
        System.out.println(cis.equals(cis2)); // true
    }
}

// 实现了不区分大小写的字符串。字符串被 toString 保存，但在 equals 比较中被忽略
class CaseInsensitiveString02 {
    private final String s;

    public CaseInsensitiveString02(String s) {
        this.s = Objects.requireNonNull(s);
    }

    // Broken - violates symmetry!
    @Override
    public boolean equals(Object o) {
        return o instanceof CaseInsensitiveString02 && ((CaseInsensitiveString02)o).s.equalsIgnoreCase(s);
    }
}