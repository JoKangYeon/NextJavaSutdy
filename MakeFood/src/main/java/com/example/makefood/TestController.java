package com.example.makefood;

import com.example.makefood.databox.FoodDTO;
import com.example.makefood.databox.MemberService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class TestController {

    @FXML
    private AnchorPane container;

    @FXML
    private VBox foodBox;

    MemberService memberService = MemberService.getInstance();
    ArrayList<FoodDTO> result = new ArrayList<>();

    @FXML
    public void initList() {
        ArrayList<FoodDTO> chooseList = new ArrayList<>(memberService.getFoodList(memberService.food));
        result.addAll(chooseList);
        System.out.println(chooseList.size());

        int check = 0;
        for(int i = 0; i < chooseList.size()/3; i++){
                VBox vBox = new VBox();
                container.getChildren().add(vBox);
                for(int j = 0; j < 3; j++){
                    HBox hBox = new HBox();
                    Label label = new Label();
                    ImageView imageView = new ImageView();
                    vBox.getChildren().add(hBox);
                    hBox.getChildren().add(label);
                    hBox.getChildren().add(imageView);

                    label.setText(chooseList.get(check).getFoodName());
                    imageView.setImage(new Image(chooseList.get(check).getFoodImage()));
                    check++;
                }
            foodBox.getChildren().add(vBox);
        }


    }


}
