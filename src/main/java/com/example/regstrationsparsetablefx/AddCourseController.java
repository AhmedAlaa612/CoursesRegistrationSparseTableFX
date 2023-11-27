package com.example.regstrationsparsetablefx;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AddCourseController {
    @FXML
    private TextField courseNameFeild;
    @FXML
    private TextField courseIdFeild;
    @FXML
    public void AddCourse(){
        String name = courseNameFeild.getText();
        String id = courseIdFeild.getText();
        if (name.isEmpty() || id.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Incomplete Data");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all fields.");
            alert.showAndWait();
            return;
        }
        try{
            SparseTable.getInstance().addCourse(name, id);
        } catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Something went wrong");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
            return;
        }
        courseNameFeild.clear();
        courseIdFeild.clear();
    }
}
