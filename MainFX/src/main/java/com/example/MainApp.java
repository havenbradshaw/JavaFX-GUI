package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
    Label statusLabel = new Label("Current shape: Rectangle");
        

        Canvas canvas = new Canvas(400, 400);
        
        //creates drawingcontroller object to keep up with shapes
        DrawingController drawingController = new DrawingController();
        
        // creates label to count shapes
        Label countLabel = new Label("Shapes: 0");
        
        //binds areaLabel to the drawingController totalAreaProperty
        Label areaLabel = new Label();
        areaLabel.textProperty().bind(drawingController.totalAreaProperty().asString("Total area: %.2f"));

        // Create the clear button
        Button clearButton = new Button("Clear Canvas");
        clearButton.setOnAction(e -> {
            canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            drawingController.clear();
            countLabel.setText("Shapes: 0");
        });

        // ToggleGroup and RadioButtons for shape selection
        ToggleGroup shapeToggleGroup = new ToggleGroup();
        RadioButton rectRadio = new RadioButton("Rectangle");
        rectRadio.setToggleGroup(shapeToggleGroup);
        rectRadio.setSelected(true);
        rectRadio.setTooltip(new Tooltip("Draw rectangles on the canvas"));
        RadioButton circleRadio = new RadioButton("Circle");
        circleRadio.setToggleGroup(shapeToggleGroup);
        circleRadio.setTooltip(new Tooltip("Draw circles on the canvas"));

        // Update status label when selection changes
        shapeToggleGroup.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            if (newToggle == rectRadio) {
                statusLabel.setText("Current shape: Rectangle");
            } else if (newToggle == circleRadio) {
                statusLabel.setText("Current shape: Circle");
            }
        });

        // Draw shape on mouse click and remember it
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            if (rectRadio.isSelected()) {
                RectangleShape rectangle = new RectangleShape(event.getX(), event.getY(), 60, 40);
                drawingController.addShape(rectangle);
            } else {
                CircleShape circle = new CircleShape(event.getX(), event.getY(), 30);
                drawingController.addShape(circle);
            }
            // Redraw all shapes
            canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            drawingController.drawAll(canvas.getGraphicsContext2D());
            countLabel.setText("Shapes: " + drawingController.getShapes().size());
        });

        // Layout for top controls
    HBox topControls = new HBox(10, clearButton, rectRadio, circleRadio, countLabel, statusLabel, areaLabel);
    topControls.setPadding(new Insets(10));

        BorderPane root = new BorderPane();
        root.setTop(topControls);
        root.setCenter(canvas);
        Scene scene = new Scene(root, 600, 400);
        // Keyboard shortcuts
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case C -> clearButton.fire();
                case R -> rectRadio.setSelected(true);
                case O -> circleRadio.setSelected(true);
                default -> {
            }
            }
        });
        primaryStage.setTitle("Shape Drawing App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
