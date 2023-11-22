package com.example.makefood.common;

import javafx.scene.control.Alert;

public class MyAlert {

    public static void showAlertInfo(String msg){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.show();
    }
}
