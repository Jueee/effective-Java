package com.jueee.item23;

public class Item23Example02 {

    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println(circle.area());
        
        Rectangle rectangle = new Rectangle(5, 3);
        System.out.println(rectangle.area());
    }
}

// Class hierarchy replacement for a tagged class
abstract class Figure2 {
    abstract double area();
}

class Circle extends Figure2 {
    final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * (radius * radius);
    }
}

class Rectangle extends Figure2 {
    final double length;
    final double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}
