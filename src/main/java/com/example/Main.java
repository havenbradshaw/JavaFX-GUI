package com.example;

// JavaFX application to draw a circle based on two mouse clicks
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Main class extending Application
public class Main extends Application {
    private static final double CIRCLE_RADIUS = 100; // Set your desired radius here

    // Override the start method
    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        Pane drawPane = new Pane();
        drawPane.setPrefSize(1000, 700);
        ToggleGroup shapeGroup = new ToggleGroup();
        RadioButton circleRadio = new RadioButton("Circle");
        RadioButton rectRadio = new RadioButton("Rectangle");
        circleRadio.setToggleGroup(shapeGroup);
        rectRadio.setToggleGroup(shapeGroup);
        circleRadio.setSelected(true); // Default selection
        Button clearButton = new Button("Clear Canvas");
        clearButton.setOnAction(e -> drawPane.getChildren().clear());
        root.getChildren().addAll(circleRadio, rectRadio, clearButton, drawPane);
        Scene scene = new Scene(root, 1000, 750);

        drawPane.setOnMouseClicked(event -> {
            double clickX = event.getX();
            double clickY = event.getY();
            if (rectRadio.isSelected()) {
                com.example.Rectangle dataRect = new com.example.Rectangle(clickX - 200, clickY - 100, 400, 200, "red");
                javafx.scene.shape.Rectangle fxRect = new javafx.scene.shape.Rectangle(
                    dataRect.getX(), dataRect.getY(), dataRect.getWidth(), dataRect.getHeight()
                );
                fxRect.setFill(javafx.scene.paint.Color.valueOf(dataRect.getColor()));
                drawPane.getChildren().add(fxRect);
            } else if (circleRadio.isSelected()) {
                com.example.Circle dataCircle = new com.example.Circle(clickX, clickY, CIRCLE_RADIUS, "blue");
                javafx.scene.shape.Circle fxCircle = new javafx.scene.shape.Circle(
                    dataCircle.getCenterX(), dataCircle.getCenterY(), dataCircle.getRadius()
                );
                fxCircle.setFill(javafx.scene.paint.Color.valueOf(dataCircle.getColor()));
                drawPane.getChildren().add(fxCircle);
            }
        });

        primaryStage.setTitle("Draw Circle or Rectangle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Main method to launch the application
    public static void main(String[] args) {
        launch(args);
    }
}