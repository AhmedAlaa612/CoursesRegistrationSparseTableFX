package com.example.regstrationsparsetablefx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    public static Stage primaryStage;
    @Override
    public void start(Stage primaryStage) throws IOException {
        Main.primaryStage = primaryStage;
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("MainView.fxml"));
        BorderPane root = loader.load();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
