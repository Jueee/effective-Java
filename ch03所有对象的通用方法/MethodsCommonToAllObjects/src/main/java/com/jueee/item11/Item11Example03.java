package com.jueee.item11;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Item11Example03 {

    public static void main(String[] args) {
        Map<PhoneNumber3, String> m = new HashMap<>();
        m.put(new PhoneNumber3(707, 867, 5309), "Jenny");
        System.out.println(m.get(new PhoneNumber3(707, 867, 5309))); // Jenny
    }
}


final class PhoneNumber3 {

    private final short areaCode, prefix, lineNum;

    public PhoneNumber3(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);

        return (short)val;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber3))
            return false;

        PhoneNumber3 pn = (PhoneNumber3)o;

        return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode;
    }

    // 单行hashCode方法-性能中等
    @Override 
    public int hashCode() {
        return Objects.hash(lineNum, prefix, areaCode);
    }
}