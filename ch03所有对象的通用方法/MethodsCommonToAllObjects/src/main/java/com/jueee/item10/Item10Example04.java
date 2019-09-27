package com.jueee.item10;

import java.awt.Color;

// 符合对称性，但是丧失了传递性：
public class Item10Example04 {

    public static void main(String[] args) {
        Point02 p = new Point02(1, 2);
        ColorPoint02 cp1 = new ColorPoint02(1, 2, Color.RED);
        ColorPoint02 cp2 = new ColorPoint02(1, 2, Color.BLUE);
        System.out.println(p.equals(cp1)); // true
        System.out.println(cp1.equals(p)); // true
        System.out.println(p.equals(cp2)); // true
        System.out.println(cp2.equals(p)); // true
        System.out.println(cp1.equals(cp2)); // false
        System.out.println(cp2.equals(cp1)); // false
    }
}

class ColorPoint02 extends Point02 {
    private final Color color;

    public ColorPoint02(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }
    
    @Override 
    public boolean equals(Object o) {
        if (!(o instanceof Point02))
            return false;

        // If o is a normal Point, do a color-blind comparison
        if (!(o instanceof ColorPoint02))
            return o.equals(this);

        // o is a ColorPoint; do a full comparison
        return super.equals(o) && ((ColorPoint02) o).color == color;
    }

}

// 简单不可变的二维整数类型 Point 类
class Point02 {
    private final int x;
    private final int y;

    public Point02(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point02))
            return false;
        Point02 p = (Point02) o;
        return p.x == x && p.y == y;
    }
}