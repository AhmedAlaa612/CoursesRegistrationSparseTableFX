package com.example.regstrationsparsetablefx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class StudentSceneControllers {

    @FXML
    private BorderPane studentPane;
    @FXML
    private void switchToAllStudents() {
        switchScene("AllStudentsScene.fxml");
    }
    @FXML
    private void switchToAdd() {
        switchScene("AddStudentScene.fxml");
    }
    @FXML
    private void switchToDelete() {
        switchScene("DeleteStudentScene.fxml");
    }
    @FXML
    private void switchToEnroll() {
        switchScene("EnrollScene.fxml");
    }
    @FXML
    private void switchToWithdraw() {
        switchScene("WithdrawScene.fxml");
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
