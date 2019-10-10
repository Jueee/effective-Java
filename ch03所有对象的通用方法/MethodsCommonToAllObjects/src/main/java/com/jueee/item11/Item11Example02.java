package com.jueee.item11;

import java.util.HashMap;
import java.util.Map;

public class Item11Example02 {

    public static void main(String[] args) {
        Map<PhoneNumber2, String> m = new HashMap<>();
        m.put(new PhoneNumber2(707, 867, 5309), "Jenny");
        System.out.println(m.get(new PhoneNumber2(707, 867, 5309))); // Jenny
    }
}


final class PhoneNumber2 {

    private final short areaCode, prefix, lineNum;

    public PhoneNumber2(int areaCode, int prefix, int lineNum) {
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
        if (!(o instanceof PhoneNumber2))
            return false;

        PhoneNumber2 pn = (PhoneNumber2)o;

        return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode;
    }

    // 典型的hashCode方法
    @Override 
    public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }
}