package com.jueee.item11;

import java.util.HashMap;
import java.util.Map;

public class Item11Example01 {

    public static void main(String[] args) {
        Map<PhoneNumber1, String> m = new HashMap<>();
        m.put(new PhoneNumber1(707, 867, 5309), "Jenny");
        System.out.println(m.get(new PhoneNumber1(707, 867, 5309))); // null
    }
}


final class PhoneNumber1 {

    private final short areaCode, prefix, lineNum;

    public PhoneNumber1(int areaCode, int prefix, int lineNum) {
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
        if (!(o instanceof PhoneNumber1))
            return false;

        PhoneNumber1 pn = (PhoneNumber1)o;

        return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode;
    }

}