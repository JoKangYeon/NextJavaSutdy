module com.example.upgradeweapon {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.upgradeweapon to javafx.fxml;
    exports com.example.upgradeweapon;
}