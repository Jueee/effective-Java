package com.jueee.item10;

public class Item10Example06 {

    public static void main(String[] args) {
        PhoneNumber n1 = new PhoneNumber(3, 5, 8);
        PhoneNumber n2 = new PhoneNumber(3, 5, 8);
        PhoneNumber n3 = new PhoneNumber(3, 5, 8);
        System.out.println(n1.equals(n2)); // true
        System.out.println(n2.equals(n1)); // true
        System.out.println(n2.equals(n3)); // true
        System.out.println(n3.equals(n1)); // true
    }
}

final class PhoneNumber {

    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
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
        if (!(o instanceof PhoneNumber))
            return false;

        PhoneNumber pn = (PhoneNumber)o;

        return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode;
    }

}