package com.example;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.canvas.GraphicsContext;

/**
 * Controller for managing and drawing all shapes in the application.
 * Tracks the list of shapes and provides properties for UI binding.
 */
public class DrawingController {
	private final List<DrawableShape> shapes = new ArrayList<>();
	private final DoubleProperty totalArea = new SimpleDoubleProperty(0);

	/**
	 * Adds a shape to the list and updates the total area property.
	 * @param shape the shape to add
	 */
	public void addShape(DrawableShape shape) {
		shapes.add(shape);
		updateTotalArea();
	}

	/**
	 * Draws all shapes onto the provided GraphicsContext.
	 * @param gc the GraphicsContext to draw on
	 */
	public void drawAll(GraphicsContext gc) {
		for (DrawableShape shape : shapes) {
			shape.draw(gc);
		}
	}

	/**
	 * Removes all shapes and resets the total area property.
	 */
	public void clear() {
		shapes.clear();
		updateTotalArea();
	}
	/**
	 * Recalculates the total area of all shapes and updates the property.
	 */
	private void updateTotalArea() {
		double sum = 0;
		for (DrawableShape shape : shapes) {
			sum += shape.getArea();
		}
		totalArea.set(sum);
	}


	/**
	 * Returns a property representing the total area of all shapes.
	 * @return the total area property
	 */
	public DoubleProperty totalAreaProperty() {
		return totalArea;
	}

	/**
	 * Returns a copy of the list of all shapes.
	 * @return a list of shapes
	 */
	public List<DrawableShape> getShapes() {
		return new ArrayList<>(shapes);
	}
}


