package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        //Button btn = new Button("Say 'Hello World'");
        //btn.setOnAction(event -> System.out.println("Hello World"));

        StackPane root = new StackPane();
        //root.getChildren().add(btn);

        Scene scene = new Scene(root, 1000, 650);
        primaryStage.setTitle("Shape Drawer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}