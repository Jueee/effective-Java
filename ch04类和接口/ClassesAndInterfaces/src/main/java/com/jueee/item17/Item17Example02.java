package com.jueee.item17;

public class Item17Example02 {
    
    // 公共的静态 final 常量。
    public static final Complex2 ZERO = Complex2.valueOf(0, 0);
    public static final Complex2 ONE  = Complex2.valueOf(1, 0);
    public static final Complex2 I    = Complex2.valueOf(0, 1);

    public static void main(String[] args) {
        Complex2 complex1 = Complex2.valueOf(3, 5);
        Complex2 complex2 = Complex2.valueOf(-1, -8);
        
        System.out.println(complex1.plus(complex2));
        System.out.println(complex1.minus(complex2));
        System.out.println(complex1.times(complex2));
        System.out.println(complex1.dividedBy(complex2));
    }
}

// 不变复数类
class Complex2 {

    private final double re;
    private final double im;

    private Complex2(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static Complex2 valueOf(double re, double im) {
        return new Complex2(re, im);
    }

    public double realPart() {
        return re;
    }

    public double imaginaryPart() {
        return im;
    }

    public Complex2 plus(Complex2 c) {
        return new Complex2(re + c.re, im + c.im);
    }

    public Complex2 minus(Complex2 c) {
        return new Complex2(re - c.re, im - c.im);
    }

    public Complex2 times(Complex2 c) {
        return new Complex2(re * c.re - im * c.im, re * c.im + im * c.re);
    }

    public Complex2 dividedBy(Complex2 c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex2((re * c.re + im * c.im) / tmp, (im * c.re - re * c.im) / tmp);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Complex2)) {
            return false;
        }

        Complex2 c = (Complex2)o;

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
