package com.example.makefood;

import com.example.makefood.common.MyAlert;
import com.example.makefood.databox.FoodDTO;
import com.example.makefood.databox.MemberService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class IntroController {

    @FXML
    private AnchorPane container;

    @FXML
    public ComboBox foodIn;



    MemberService memberService = MemberService.getInstance();

    @FXML
    public void showMain() throws IOException {
        if(foodIn.getValue() == null){
            MyAlert.showAlertInfo("음식을 선택해주세요");
            return;
        }

        memberService.food = foodIn.getValue().toString();

        Stage stage = (Stage) container.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        MainController mc = fxmlLoader.getController();
        mc.initList();
//        TestController tc = fxmlLoader.getController();
//        tc.initList();
        stage.setScene(scene);
    }


}
