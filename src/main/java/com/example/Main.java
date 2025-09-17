package com.example;

// JavaFX application to draw a circle based on two mouse clicks
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

// Main class extending Application
public class Main extends Application {
    private double x1, y1, x2, y2;
    private boolean firstClick = true;

    // Override the start method
    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 1000, 750);

        // Set mouse click event handler
        scene.setOnMouseClicked(event -> {
            if (firstClick) {
                x1 = event.getX();
                y1 = event.getY();
                firstClick = false;
            } else {
                x2 = event.getX();
                y2 = event.getY();
                // Calculate center as midpoint
                double centerX = (x1 + x2) / 2.0;
                double centerY = (y1 + y2) / 2.0;
                // Calculate radius as half the distance between points
                double radius = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)) / 2.0;
                javafx.scene.shape.Circle circle = new javafx.scene.shape.Circle(centerX, centerY, radius);
                root.getChildren().add(circle);
                firstClick = true;
            }
        });

        primaryStage.setTitle("Draw Circle by Two Clicks");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Main method to launch the application
    public static void main(String[] args) {
        launch(args);
    }
}