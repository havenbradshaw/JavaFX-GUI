package com.example;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
//circle class
public class CircleShape implements DrawableShape {
    private final double r;
    private final double x;
    private final double y;
    //constructor 
    public CircleShape(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.FLORALWHITE); // Fill color
        gc.fillOval(x - r, y - r, 2 * r, 2 * r);
        gc.setStroke(Color.DARKSEAGREEN); // Outline color
        gc.strokeOval(x - r, y - r, 2 * r, 2 * r);
    }

    @Override
    public double getArea() {
        return Math.PI * r * r;
    }
}