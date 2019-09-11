package com.jueee.item01;

// 静态工厂方法可以返回原返回类型的任何子类型对象
public class Item01Example03 {

    public static void main(String[] args) {
        Item01Shape shape = Item01Shape.newInstance("");
        Item01Shape triangle = Item01Shape.newInstance("triangle");
        Item01Shape circle = Item01Shape.newInstance("circle");
        shape.getName();
        triangle.getName();
        circle.getName();
    }
}

class Item01Shape {

    private Item01Shape(){

    }
    //根据类型决定返回的对象
    public static Item01Shape newInstance(String type){
        if (type.equalsIgnoreCase("triangle")){
            return new Triangle();
        } else if (type.equalsIgnoreCase("circle")){
            return new Circle();
        }
        return new Item01Shape();
    }

    public void getName(){
        System.out.println("My name is shape");
    }

    private static class Triangle extends Item01Shape{
        public void getName(){
            System.out.println("My name is triangle");
        }
    }

    private static class Circle extends Item01Shape{
        public void getName(){
            System.out.println("My name is circle");
        }
    }
}