package com.jueee.item06;

import java.util.regex.Pattern;

public class Item06Example01 {

}

class RomanNumeralsBad {
    public static boolean isRomanNumeral(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})" + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }
}

// 重用昂贵的对象以提高性能
class RomanNumeralsGood {
    private static final Pattern ROMAN =
        Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})" + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeral(String s) {
        return ROMAN.matcher(s).matches();
    }
}
