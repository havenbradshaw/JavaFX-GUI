package com.example;

public class Rectangle {
    private final double x;
    private final double y;
    private final double width;
    private final double height;
    private final String color;

    public Rectangle(double x, double y, double width, double height, String color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }
}
