package com.example;


public class Circle {
    private final double centerX;
    private final double centerY;
    private final double radius;
    private final String color;

    public Circle(double centerX, double centerY, double radius, String color) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.color = color;
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }
}
