module com.example.flashytalk {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.flashytalk to javafx.fxml;
    exports com.example.flashytalk;
}