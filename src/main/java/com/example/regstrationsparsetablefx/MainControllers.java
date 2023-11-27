package com.example.regstrationsparsetablefx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import java.io.IOException;

public class MainControllers {

    @FXML
    private BorderPane mainPane;
    @FXML
    private void switchToDashboard() {
        switchScene("Dashboard.fxml");
    }

    @FXML
    private void switchToCourses() {
        switchScene("CourseScene.fxml");
    }
    @FXML
    private void switchToStudents() {
        switchScene("StudentScene.fxml");
    }
    @FXML
    private void switchToStudentCourses() {switchScene("StudentCoursesScene.fxml");
    }
    @FXML
    private void switchToCourseStudents() {
        switchScene("CourseStudentsScene.fxml");
    }
    private void switchScene(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            mainPane.setCenter(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
