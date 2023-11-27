package com.example.regstrationsparsetablefx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardControllers implements Initializable {
    @FXML
    private Text studentsNum;
    @FXML
    private Text coursesNum;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set the text to the size of the map
        studentsNum.setText(""+SparseTable.getInstance().students.size());
        coursesNum.setText(""+SparseTable.getInstance().courses.size());
    }
}
