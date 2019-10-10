package com.jueee.item14;

import java.util.Set;
import java.util.TreeSet;

public class Item14Example02 {

    public static void main(String[] args) {
        Set<PhoneNumber1> set = new TreeSet<>();
        set.add(new PhoneNumber1(707, 867, 5309));
        set.add(new PhoneNumber1(907, 867, 5309));
        set.add(new PhoneNumber1(507, 867, 5309));
        set.add(new PhoneNumber1(707, 667, 5309));
        set.add(new PhoneNumber1(707, 967, 5309));
        
        for(PhoneNumber1 phoneNumber1: set) {
            System.out.println(phoneNumber1.toString());
        }
    }
}



class PhoneNumber1 implements Comparable<PhoneNumber1>{

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
    public String toString() {
        return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
    }

    @Override
    public int compareTo(PhoneNumber1 pn) {
        int result = Short.compare(areaCode, pn.areaCode);
        if (result == 0) {
            result = Short.compare(prefix, pn.prefix);
            if (result == 0)
                result = Short.compare(lineNum, pn.lineNum);
        }
        return result;
    }

}