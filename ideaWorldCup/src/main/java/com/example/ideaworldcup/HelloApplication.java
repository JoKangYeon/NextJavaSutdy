package com.example.ideaworldcup;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        // fxmlLoader.load()가 실행된 이후 fxmlLoader로부터
        // .fxml 와 연결된 Controller를 꺼낼 수 있다.
        HelloController hc = fxmlLoader.getController();
        hc.initList();



        stage.setTitle("아이돌 이상형 월드컵");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}