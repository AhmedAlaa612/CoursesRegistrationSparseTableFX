package com.example.regstrationsparsetablefx;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class AllStudentsControllers implements Initializable {
    @FXML
    private TableView<Ptr> StudentTable;
    @FXML
    private TableColumn<Ptr, String> name;
    @FXML
    private TableColumn<Ptr, String> id;
    public void load_data(){
        StudentTable.setItems(SparseTable.getInstance().StudentsList);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //load data
        load_data();
        // Initialize the columns
        name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        // Add a listener to the book list
        SparseTable.getInstance().StudentsList.addListener((ListChangeListener.Change<? extends Ptr> change) -> {
            // In the listener, add the new object to the tableview.
            while (change.next()) {
                if (change.wasAdded() || change.wasRemoved()) {
                    load_data();
                }
            }
        });
    }
}
