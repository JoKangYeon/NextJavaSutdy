package com.example.upgradeweapon;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    HelloController hc;

    // main 메소드의 launch가 실행되면 start가 실행된다.
    @Override
    public void start(Stage stage) throws IOException {
        // FXMLLoader는 hello-view.fxml 를 읽어온 객체
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        // hello-view.fxml 은 내부에 HelloController 를 가르키고 있다.
        // -> FXMLLoader를 이용하여 HelloController에 접근 가능하다.
        // -> fxmlLoader 는 .load() 까지 실행되어야 제대로 hello-view.fxml 를 불러온다.

//        Scene scene = new Scene(fxmlLoader.load(), 500, 700);

        // 화면크기를 지정 안하면, 내부 요소를 감싸는 크기로 만들어진다.
        Scene scene = new Scene(fxmlLoader.load());

        // fxmlLoader로부터 Controller 꺼내기
        hc = fxmlLoader.getController();
        // Controller 내 메소드 실행
        hc.autoIncome();


        // 어플리케이션 창의 제목이 된다.
        stage.setTitle("무기강화게임");
        stage.setScene(scene);
        stage.show();
    }

    // 어플리케이션 종료시 실행되는 메소드 (feat. 라이프사이클)
    @Override
    public void stop() throws Exception {
        // 멀티스레드에게 준 일을 끝낸다 -> while문 종료시켜주기
        hc.stopThread();
    }

    public static void main(String[] args) {
        launch();
    }
}