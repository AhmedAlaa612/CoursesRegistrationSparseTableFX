package com.example.regstrationsparsetablefx;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class EnrollSceneControllers {
 @FXML
 private TextField studentIdFeild;
 @FXML
 private TextField courseIdFeild;
 @FXML
 public void enroll(){
  String student_id = studentIdFeild.getText();
  String course_id = courseIdFeild.getText();
  if (student_id.isEmpty() || course_id.isEmpty()){
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Incomplete Data");
    alert.setHeaderText(null);
    alert.setContentText("Please fill all fields.");
    alert.showAndWait();
    return;
  }
  try {
      SparseTable.getInstance().enroll(student_id, course_id);
  }
  catch (Exception ex){
   Alert alert = new Alert(Alert.AlertType.WARNING);
   alert.setTitle("Something went wrong");
   alert.setHeaderText(null);
   alert.setContentText(ex.getMessage());
   alert.showAndWait();
   return;
  }
  studentIdFeild.clear();
  courseIdFeild.clear();
 }
}
