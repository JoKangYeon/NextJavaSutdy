package com.example.lottoshop;

import com.example.lottoshop.common.UtilClass;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Arrays;

public class HelloController {


    @FXML
    private TextField inputCount;

    @FXML
    private VBox lottoBox;

    @FXML
    public void onBuy(){
        // TextField에 적힌 수량만큼 로또 번호를 생성해서 화면에 출력

        // VBox 내부 요소 제거
        lottoBox.getChildren().clear();

        // 1등 당첨번호와 비교해서 포함되는 번호에만 배경색 적용
        // 7 18 19 26 33 45
        ArrayList<Integer> winLotto = new ArrayList<>(Arrays.asList(7, 18, 19, 26,33, 45));

        // 1. TextField 로부터 입력받은 내용 가져오기
        // (숫자를 입력해도 String 타입으로 리턴)
        int count = Integer.parseInt(inputCount.getText());

        // 2. 로또 번호를 count 개수만큼 생성
        for(int i = 0; i < count; i++){
            ArrayList<Integer> lotto = UtilClass.getLottoList();

            // 3. 생성된 로또 번호를 화면에 그려주기
            // (HBox를 만들고, 그안에 로또 번호가 담기 Label을
            // 6개 담은 후 VBox에 추가)

            HBox hbox = new HBox();
            for(int k = 0; k < lotto.size(); k++){
                // Label 객체 생성
                Label num = new Label();
                // Label 객체 내부 글자 지정
                num.setText(lotto.get(k) + "");

                // Label 객체 내부 글자 글꼴, 크기 지정
                num.setFont(Font.font("Arial", 20));

                // Label 객체 너비(width) 지정
                num.setPrefWidth(33);
                // Label 객체 높이(height) 지정
                num.setPrefHeight(33);
                // 수평 정렬 설정
                num.setAlignment(Pos.CENTER);
                // 내부 요소 수직 정렬 설정
                num.setStyle("-fx-alignment: center;");

                // 테두리 설정 (1px solid black)

                // 해당 번호가 당첨번호에 속해있다면 배경색 변경
                if(winLotto.contains(lotto.get(k))){
                    // 배경색 설정 (background-color)
                    // 커스텀 색 설정 (#66FFCC)
                    Color customColor = Color.web("#33FFCC");
                    BackgroundFill backgroundFill = new BackgroundFill(customColor, null, null);
//                BackgroundFill backgroundFill = new BackgroundFill(Color.LIGHTGREEN, null, null);
                    Background background = new Background(backgroundFill);
                    num.setBackground(background);
                }
                BorderStroke stroke = new BorderStroke(Color.LIGHTGRAY
                        , BorderStrokeStyle.SOLID
                        , null
                        // 위, 오른쪽, 아래, 왼쪽 테두리 두께
                        , new BorderWidths(0, 1, 0, 1));
                Border border = new Border(stroke);
                num.setBorder(border);


                // Hbox 내부에 Label 객체 추가 (js = appendChild)
                hbox.getChildren().add(num);

                // HBox 에도 테두리 추가
                hbox.setBorder( new Border(new BorderStroke(Color.BLACK
                                        , BorderStrokeStyle.SOLID
                                        , null
                                        // 위, 오른쪽, 아래, 왼쪽 테두리 두께
                                        , new BorderWidths(1, 1, 1, 1))));
            }

            // vBox 내부에 HBox 객체 추가
            lottoBox.getChildren().add(hbox);


        }
    }

}