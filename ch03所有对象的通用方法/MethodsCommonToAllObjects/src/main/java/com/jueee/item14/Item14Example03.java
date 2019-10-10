package com.jueee.item14;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Item14Example03 {

    public static void main(String[] args) {
        Set<PhoneNumber2> set = new TreeSet<>();
        set.add(new PhoneNumber2(707, 867, 5309));
        set.add(new PhoneNumber2(907, 867, 5309));
        set.add(new PhoneNumber2(507, 867, 5309));
        set.add(new PhoneNumber2(707, 667, 5309));
        set.add(new PhoneNumber2(707, 967, 5309));
        
        for(PhoneNumber2 phoneNumber1: set) {
            System.out.println(phoneNumber1.toString());
        }
    }
}



class PhoneNumber2 implements Comparable<PhoneNumber2>{

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
    public String toString() {
        return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
    }
    
    private static final Comparator<PhoneNumber2> COMPARATOR =
        Comparator.comparingInt((PhoneNumber2 pn) -> pn.areaCode)
          .thenComparingInt(pn -> pn.prefix)
          .thenComparingInt(pn -> pn.lineNum);

    @Override
    public int compareTo(PhoneNumber2 pn) {
        return COMPARATOR.compare(this, pn);
    }

}