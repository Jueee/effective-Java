package com.jueee.item34;

public class Item34Example04 {

    // Enum type that switches on its own value - questionable
    public enum Operation {
        PLUS, MINUS, TIMES, DIVIDE;

        // Do the arithmetic operation represented by this constant
        public double apply(double x, double y) {
            switch(this) {
                case PLUS:   return x + y;
                case MINUS:  return x - y;
                case TIMES:  return x * y;
                case DIVIDE: return x / y;
            }
            throw new AssertionError("Unknown op: " + this);
        }
    }

    public static void main(String[] args) {
        double x = Double.parseDouble("13");
        double y = Double.parseDouble("2");
        for (Operation op : Operation.values()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }

}
