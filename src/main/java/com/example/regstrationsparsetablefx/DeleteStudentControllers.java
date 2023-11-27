package com.example.regstrationsparsetablefx;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class DeleteStudentControllers {
    @FXML
    private TextField IdFeild;

    public void delete(){
        String student_id = IdFeild.getText();
        if (student_id.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Incomplete Data");
            alert.setHeaderText(null);
            alert.setContentText("Please add student Id");
            alert.showAndWait();
            return;
        }
        try{
            SparseTable.getInstance().deleteStudent(student_id);
        }
        catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Something went wrong");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
        IdFeild.clear();
    }
}
