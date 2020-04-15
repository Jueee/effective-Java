package com.jueee.item34;

public class Item34Example05 {

    // Enum type with constant-specific method implementations
    public enum Operation {
        PLUS {
            @Override
            public double apply(double x, double y) {
                return x + y;
            }
        },
        MINUS {
            @Override
            public double apply(double x, double y) {
                return x - y;
            }
        },
        TIMES {
            @Override
            public double apply(double x, double y) {
                return x * y;
            }
        },
        DIVIDE {
            @Override
            public double apply(double x, double y) {
                return x / y;
            }
        };

        public abstract double apply(double x, double y);
    }

    public static void main(String[] args) {
        double x = Double.parseDouble("13");
        double y = Double.parseDouble("2");
        for (Operation op : Operation.values()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}
