package com.example.ideaworldcup;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class HelloController {

    @FXML
    private ImageView leftImage;

    @FXML
    private ImageView rightImage;

    @FXML
    private Label leftName;

    @FXML
    private Label rightName;

    @FXML
    private Label round;

    // 현재게임중인 이미지 리스트의 인덱스
    private int currentIndex = 0;

    // 전체 이미지 리스트
    private ArrayList<String> allImgList = new ArrayList<>();

    // 선택된 이미지 리스트
    private ArrayList<String> choiceList = new ArrayList<>();

    // 처음 실행시 세팅해주는 메소드
    public void initList(){
        String path = System.getProperty("user.dir");
        File imgFolder =new File(path + "/src/main/resources/images");

        File[] imgArray =imgFolder.listFiles();
        for(int i = 0; i < imgArray.length; i++){
            System.out.println(imgArray[i].getName());
            allImgList.add(imgArray[i].getName());
        }

        // allImgList 섞기
        Collections.shuffle(allImgList);

        // 초기 화면 세팅
        String left = allImgList.get(currentIndex++);
        leftImage.setImage(new Image(getClass().getResource("/images/" + left).toString()));
        Color customColor = Color.web("#00000055");
        BackgroundFill backgroundFill = new BackgroundFill(customColor, null, null);
        Background background = new Background(backgroundFill);
        leftName.setBackground(background);

        // 글자색 지정
        leftName.setTextFill(Color.WHITE);
        leftName.setFont(Font.font("arial", 20));
        // allImgList.get(0) 에서 .jpg || .jpeg 등등 제외한
        // 이름 부분만 Label에 적용
        // split을 사용한 나누기
        String[] temp = left.split("\\.");
        leftName.setText(temp[0]);
        // substring을 이용한 방법
//        leftName.setText(left.substring(0, left.indexOf(".")));
        // Padding 지정
        leftName.setPadding(new Insets(10,13,10,13));
        leftName.setAlignment(Pos.CENTER);
        leftName.setStyle("-fx-alignment: center;");

        String right =allImgList.get(currentIndex++);
        rightImage.setImage(new Image(getClass().getResource("/images/" + right).toString()));
        rightName.setText(right.substring(0, right.indexOf(".")));
        rightName.setBackground(background);
        rightName.setTextFill(Color.WHITE);
        rightName.setFont(Font.font("arial", 20));
        rightName.setPadding(new Insets(10,13,10,13));
        rightName.setAlignment(Pos.CENTER);
        rightName.setStyle("-fx-alignment: center;");

    }

    @FXML
    public void leftClick(){
    // allImgList의 왼쪽꺼를 choiceList에 담음
        choiceList.add(allImgList.get(currentIndex-2));
        changeImage();
        System.out.println(currentIndex);

    }

    @FXML
    public void rightClick(){
        choiceList.add(allImgList.get(currentIndex-1));
        changeImage();
    }


    public void changeImage(){
        leftImage.setImage(new Image(getClass().getResource("/images/" + allImgList.get(currentIndex)).toString()));
        rightImage.setImage(new Image(getClass().getResource("/images/" + allImgList.get(currentIndex+1)).toString()));
        leftName.setText(allImgList.get(currentIndex).substring(0, allImgList.get(currentIndex).indexOf(".")));
        rightName.setText(allImgList.get(currentIndex+1).substring(0, allImgList.get(currentIndex+1).indexOf(".")));
        currentIndex += 2;
    }











}