package com.example;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
//rectangle class
public class RectangleShape implements DrawableShape {
    private final double x;
    private final double y;
    private final double width;
    private final double height;
    //constructor 
    public RectangleShape(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.DARKOLIVEGREEN); // Fill color
        gc.fillRect(x, y, width, height);
        gc.setStroke(Color.LIGHTGOLDENRODYELLOW); // Outline color
        gc.strokeRect(x, y, width, height);
    }

    @Override
    public double getArea() {
        return width * height;
    }
}
