module com.example.regstrationsparsetablefx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.regstrationsparsetablefx to javafx.fxml;
    exports com.example.regstrationsparsetablefx;
}