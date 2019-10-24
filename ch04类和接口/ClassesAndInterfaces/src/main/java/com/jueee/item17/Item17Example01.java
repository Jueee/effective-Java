package com.jueee.item17;

public class Item17Example01 {
    
    // 公共的静态 final 常量。
    public static final Complex1 ZERO = new Complex1(0, 0);
    public static final Complex1 ONE  = new Complex1(1, 0);
    public static final Complex1 I    = new Complex1(0, 1);

    public static void main(String[] args) {
        Complex1 complex1 = new Complex1(3, 5);
        Complex1 complex2 = new Complex1(-1, -8);
        
        System.out.println(complex1.plus(complex2));
        System.out.println(complex1.minus(complex2));
        System.out.println(complex1.times(complex2));
        System.out.println(complex1.dividedBy(complex2));
    }
}

// 不变复数类
final class Complex1 {

    private final double re;
    private final double im;

    public Complex1(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double realPart() {
        return re;
    }

    public double imaginaryPart() {
        return im;
    }

    public Complex1 plus(Complex1 c) {
        return new Complex1(re + c.re, im + c.im);
    }

    public Complex1 minus(Complex1 c) {
        return new Complex1(re - c.re, im - c.im);
    }

    public Complex1 times(Complex1 c) {
        return new Complex1(re * c.re - im * c.im, re * c.im + im * c.re);
    }

    public Complex1 dividedBy(Complex1 c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex1((re * c.re + im * c.im) / tmp, (im * c.re - re * c.im) / tmp);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Complex1)) {
            return false;
        }

        Complex1 c = (Complex1)o;

        // See page 47 to find out why we use compare instead of ==
        return Double.compare(c.re, re) == 0 && Double.compare(c.im, im) == 0;

    }

    @Override
    public int hashCode() {
        return 31 * Double.hashCode(re) + Double.hashCode(im);
    }

    @Override
    public String toString() {
        return "(" + re + " + " + im + "i)";
    }
}
