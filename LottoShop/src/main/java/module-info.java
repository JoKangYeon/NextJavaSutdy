module com.example.lottoshop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lottoshop to javafx.fxml;
    exports com.example.lottoshop;
}