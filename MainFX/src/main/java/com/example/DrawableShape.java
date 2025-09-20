package com.example;

import javafx.scene.canvas.GraphicsContext;
//shape interface
public interface DrawableShape {
    void draw(GraphicsContext gc);
    double getArea();
}