module com.example.makefood {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires java.sql;
    requires com.oracle.database.jdbc;


    opens com.example.makefood to javafx.fxml;
    exports com.example.makefood;
}