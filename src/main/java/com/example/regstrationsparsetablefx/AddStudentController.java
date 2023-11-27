package com.example.regstrationsparsetablefx;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AddStudentController {
    @FXML
    private TextField studentNameFeild;
    @FXML
    private TextField studentIdFeild;

    @FXML
    public void AddStudent(){
        String name = studentNameFeild.getText();
        String id = studentIdFeild.getText();
        if (name.isEmpty() || id.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Incomplete Data");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all fields.");
            alert.showAndWait();
            return;
        }
        try{
            SparseTable.getInstance().addStudent(name, id);
        } catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Something went wrong");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
            return;
        }
        studentNameFeild.clear();
        studentIdFeild.clear();
    }
}
