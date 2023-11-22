package com.example.makefood;

import com.example.makefood.databox.FoodDTO;
import com.example.makefood.databox.MemberService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MainController {

    @FXML
    private AnchorPane container;

    @FXML
    private VBox foodBox;

    @FXML
    private ScrollPane scrollPane;

    MemberService memberService = MemberService.getInstance();
    ArrayList<FoodDTO> result = new ArrayList<>();

    @FXML
    public void initList() {
        ArrayList<FoodDTO> chooseList = new ArrayList<>(memberService.getFoodList(memberService.food));
        result.addAll(chooseList);
        System.out.println(chooseList.size());

        ArrayList<HBox> hBoxes = new ArrayList<>();

        for (int i = 0; i <= chooseList.size() / 3; i++) {
            HBox hBox = new HBox();
            hBoxes.add(hBox);
        }

        int countVbox = -1;
        for (int i = 0; i < chooseList.size(); i++) {
            if (i % 3 == 0) {
                countVbox++;
                foodBox.getChildren().add(hBoxes.get(countVbox));
            }
            FoodDTO temp = chooseList.get(i);
            VBox vBox = new VBox();
            // V박스 크기 및 테두리 설정
            vBox.setPrefWidth(390);
            vBox.setPrefHeight(190);
            vBox.setBorder(new Border(new BorderStroke(Color.BLACK

                    , BorderStrokeStyle.SOLID
                    , null
                    // 위, 오른쪽, 아래, 왼쪽 테두리 두께
                    , new BorderWidths(1, 1, 1, 1))));

            Label label = new Label();
            label.setFont(Font.font("Arial", 20));
            label.setAlignment(Pos.CENTER);

            ImageView imageView = new ImageView();
            // 이미지 설정
            imageView.setFitWidth(350);
            imageView.setFitHeight(150);
            imageView.setSmooth(true);

            // 클릭 시 화면이동
            imageView.setOnMouseClicked(event -> changeView(temp));

            hBoxes.get(countVbox).getChildren().add(vBox);
            vBox.getChildren().add(label);
            vBox.getChildren().add(imageView);

            label.setText(chooseList.get(i).getFoodName());
            if(chooseList.get(i).getFoodImage() == null){
                imageView.setImage(new Image("https://geojecci.korcham.net/images/no-image01.gif"));
            }else{
                imageView.setImage(new Image(chooseList.get(i).getFoodImage()));
            }
        }

    }

    @FXML
    public void changeView (FoodDTO foodDTO){
        Stage stage = (Stage) container.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("select-view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        SelectController sc = fxmlLoader.getController();
        sc.showInfo(foodDTO);
        stage.setScene(scene);
    }


}
