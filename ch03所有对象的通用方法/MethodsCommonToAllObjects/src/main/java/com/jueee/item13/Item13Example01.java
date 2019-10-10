package com.jueee.item13;

public class Item13Example01 {

    public static void main(String[] args) {
        PhoneNumber1 number1 = new PhoneNumber1(707, 867, 5309);
        System.out.println(number1);    // 707-867-5309
        
        try {
            PhoneNumber1 number2 = (PhoneNumber1)number1.clone();
            System.out.println(number2);    // 707-867-5309
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

class PhoneNumber1 implements Cloneable{

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
    protected Object clone() throws CloneNotSupportedException {
        try {
            return (PhoneNumber1) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();  // Can't happen
        }
    }
}