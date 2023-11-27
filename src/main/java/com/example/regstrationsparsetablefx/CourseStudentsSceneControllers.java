package com.example.regstrationsparsetablefx;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class CourseStudentsSceneControllers {
    @FXML
    private TextField CourseIdFeild;
    @FXML
    private Text CourseName;
    @FXML
    private Text CourseId;
    @FXML
    private TableView<Node> StudentsTable;
    @FXML
    private TableColumn<Node, String> name;
    @FXML
    private TableColumn<Node, String> id;

    ObservableList<Node> studentsList;
    public void load_data(){
        // get id from user
        String course_id = CourseIdFeild.getText();
        if (course_id.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Incomplete Data");
            alert.setHeaderText(null);
            alert.setContentText("Please add course Id");
            alert.showAndWait();
            return;
        }
        // get a list of student courses
        try{
            studentsList = SparseTable.getInstance().get_students_in_course(course_id);
            StudentsTable.setItems(studentsList);
            name.setCellValueFactory(new PropertyValueFactory<>("name"));
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            CourseName.setText("Student Name: "+studentsList.get(0).getCourse_name());
            CourseId.setText("Student Id: "+studentsList.get(0).getCourse_id());
            StudentsTable.setVisible(true);
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
