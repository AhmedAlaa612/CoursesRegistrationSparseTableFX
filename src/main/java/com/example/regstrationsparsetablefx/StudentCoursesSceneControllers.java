package com.example.regstrationsparsetablefx;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;


public class StudentCoursesSceneControllers{
    @FXML
    private TextField StdId;
    @FXML
    private Text StudentName;
    @FXML
    private Text StudentId;
    @FXML
    private TableView<Node> CoursesTable;
    @FXML
    private TableColumn<Node, String> name;
    @FXML
    private TableColumn<Node, String> id;

    ObservableList<Node> coursesList;
    public void load_data(){
        // get id from user
        String student_id = StdId.getText();
        if (student_id.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Incomplete Data");
            alert.setHeaderText(null);
            alert.setContentText("Please add student Id");
            alert.showAndWait();
            return;
        }
        // get a list of student courses
        try{
            coursesList = SparseTable.getInstance().get_student_courses(student_id);
            CoursesTable.setItems(coursesList);
            name.setCellValueFactory(new PropertyValueFactory<>("Course_name"));
            id.setCellValueFactory(new PropertyValueFactory<>("Course_id"));
            StudentName.setText("Student Name: "+coursesList.get(0).getName());
            StudentId.setText("Student Id: "+coursesList.get(0).getId());
            CoursesTable.setVisible(true);
        }catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Something went wrong");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());
            System.out.println(ex.getMessage());
            alert.showAndWait();
        }
    }
}
