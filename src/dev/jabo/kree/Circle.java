package dev.jabo.kree;

import java.awt.Point;

public class Circle {
	
	private final Point center;
    private final int radius;
   
    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public boolean contains(Point p) {  return p.distance(center) <= radius; }

    public double area()      { return Math.PI * radius * radius; }
    public double perimeter() { return 2 * Math.PI * radius;      }

    public boolean intersects(Circle c) {
        return center.distance(c.center) <= radius + c.radius;
    }

}
