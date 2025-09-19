package com.example;

// JavaFX application to draw a circle based on two mouse clicks
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Main class extending Application
public class Main extends Application {
    // Helper method to update shape counts and label
    private void updateShapeCounts(Label countLabel) {
        countLabel.setText("Circles: " + circleCount + "  Rectangles: " + rectangleCount);
    }
    private static final double CIRCLE_RADIUS = 100; // Set your desired radius here
    private final ObservableList<Object> shapes = FXCollections.observableArrayList(); // Track drawn shapes
    private int circleCount = 0;
    private int rectangleCount = 0;

    // Helper method to clear canvas and reset counts/labels
    private void clearCanvasAndCounts(Pane drawPane, Label countLabel) {
        drawPane.getChildren().clear();
        shapes.clear();
        circleCount = 0;
        rectangleCount = 0;
        countLabel.setText("Circles: 0  Rectangles: 0");
    }

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
        Label countLabel = new Label("Circles: 0  Rectangles: 0");
        Button clearButton = new Button("Clear Canvas");
        clearButton.setOnAction(e -> clearCanvasAndCounts(drawPane, countLabel));
        root.getChildren().addAll(circleRadio, rectRadio, countLabel, clearButton, drawPane);
        Scene scene = new Scene(root, 1000, 750);

            // Keyboard shortcut handler
            scene.setOnKeyPressed(event -> {
                switch (event.getCode()) {
                    case X:
                        System.out.println("X key pressed - Clear canvas");
                        clearCanvasAndCounts(drawPane, countLabel);
                        break;
                    case R:
                        rectRadio.setSelected(true);
                        System.out.println("R key pressed - Rectangle mode selected");
                        break;
                    case C:
                        circleRadio.setSelected(true);
                        System.out.println("C key pressed - Circle mode selected");
                        break;
                    default:
                        break;
                }
            });

        // Mouse click handler to draw shapes
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
                shapes.add(dataRect);
                rectangleCount++;
                updateShapeCounts(countLabel);
                System.out.println("Rectangle: x=" + dataRect.getX() + ", y=" + dataRect.getY() + ", width=" + dataRect.getWidth() + ", height=" + dataRect.getHeight() + ", color=" + dataRect.getColor());
            } else if (circleRadio.isSelected()) {
                com.example.Circle dataCircle = new com.example.Circle(clickX, clickY, CIRCLE_RADIUS, "blue");
                javafx.scene.shape.Circle fxCircle = new javafx.scene.shape.Circle(
                    dataCircle.getCenterX(), dataCircle.getCenterY(), dataCircle.getRadius()
                );
                fxCircle.setFill(javafx.scene.paint.Color.valueOf(dataCircle.getColor()));
                drawPane.getChildren().add(fxCircle);
                shapes.add(dataCircle);
                circleCount++;
                updateShapeCounts(countLabel);
                System.out.println("Circle: centerX=" + dataCircle.getCenterX() + ", centerY=" + dataCircle.getCenterY() + ", radius=" + dataCircle.getRadius() + ", color=" + dataCircle.getColor());
            }
        });

        // Set up and show the stage
        primaryStage.setTitle("Draw Circle or Rectangle");
        primaryStage.setScene(scene);
        primaryStage.show();

       
    }

    // Main method to launch the application
    public static void main(String[] args) {
        launch(args);
    }
}