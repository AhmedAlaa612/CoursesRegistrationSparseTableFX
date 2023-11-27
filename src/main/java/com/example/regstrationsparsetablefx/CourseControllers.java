package com.example.regstrationsparsetablefx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class CourseControllers {
    @FXML
    private BorderPane studentPane;
    @FXML
    private void switchToAllCourses() {
        switchScene("AllCoursesScene.fxml");
    }
    @FXML
    private void switchToAdd() {
        switchScene("AddCourseScene.fxml");
    }
    @FXML
    private void switchToDelete() {
        switchScene("DeleteCourseScene.fxml");
    }

    private void switchScene(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            studentPane.setCenter(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
