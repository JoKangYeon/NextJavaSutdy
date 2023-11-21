package com.example.makefood;

import com.example.makefood.databox.FoodDTO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SelectController {

    @FXML
    private AnchorPane container;

    @FXML
    private Label foodName;

    @FXML
    private ImageView foodView;

    @FXML
    private Label recipe;

    @FXML
    private Label ingredient;

    @FXML
    private Label carbohydrates;

    @FXML
    private Label energy;

    @FXML
    private Label protein;

    @FXML
    private Label fat;

    @FXML
    private Label natrium;

    @FXML
    private Button backBtn;

    @FXML
    public void showInfo(FoodDTO foodDTO){
        foodName.setText(foodDTO.getFoodName());
        foodView.setImage(new Image(foodDTO.getFoodImage()));
        recipe.setText(foodDTO.getFoodRecipe());
        ingredient.setText(foodDTO.getFoodIngredient());
        carbohydrates.setText(foodDTO.getInfoCar());
        energy.setText(foodDTO.getInfoEng());
        protein.setText(foodDTO.getInfoPro());
        fat.setText(foodDTO.getInfoFat());
        natrium.setText(foodDTO.getInfoNa());
    }

    @FXML
    public void backStage() throws IOException {
        Stage stage = (Stage)container.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-view.fxml"));
        Scene scene = null;
        scene = new Scene(fxmlLoader.load());

        MainController mc = fxmlLoader.getController();
        mc.initList();

        stage.setScene(scene);
    }










}
