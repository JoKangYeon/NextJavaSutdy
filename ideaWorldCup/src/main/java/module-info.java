module com.example.ideaworldcup {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ideaworldcup to javafx.fxml;
    exports com.example.ideaworldcup;
}