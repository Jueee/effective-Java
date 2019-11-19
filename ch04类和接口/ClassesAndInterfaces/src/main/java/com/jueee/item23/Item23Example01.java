package com.jueee.item23;

public class Item23Example01 {

    public static void main(String[] args) {
        Figure1 figure1 = new Figure1(5);
        System.out.println(figure1.area());

        Figure1 figure2 = new Figure1(5, 3);
        System.out.println(figure2.area());
    }
}

// 可以表示一个圆形或矩形
class Figure1 {
    enum Shape {
        RECTANGLE, CIRCLE
    };

    // Tag field - the shape of this figure
    final Shape shape;

    // These fields are used only if shape is RECTANGLE
    double length;
    double width;

    // This field is used only if shape is CIRCLE
    double radius;

    // Constructor for circle
    Figure1(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    // Constructor for rectangle
    Figure1(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        switch (shape) {
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError(shape);
        }
    }
}
