package com.example.makefood;

import com.example.makefood.databox.FoodDAO;
import com.example.makefood.databox.FoodDTO;
import com.example.makefood.databox.MemberService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class MainController {

    @FXML
    private AnchorPane container;

    @FXML
    private Label firstName;

    @FXML
    private Label secondName;

    @FXML
    private Label thirdName;

    @FXML
    private Label fourthName;

    @FXML
    private Label fifthName;

    @FXML
    private Label sixthName;

    @FXML
    private ImageView firstImage;

    @FXML
    private ImageView secondImage;

    @FXML
    private ImageView thirdImage;

    @FXML
    private ImageView fourthImage;

    @FXML
    private ImageView fifthImage;

    @FXML
    private ImageView sixthImage;

    @FXML
    private ScrollBar scrollBar;



    MemberService memberService = MemberService.getInstance();
    ArrayList<FoodDTO> result = new ArrayList<>();


    @FXML
    public void initList() {
        ArrayList<FoodDTO> chooseList = new ArrayList<>(memberService.getFoodList(memberService.food));
//        Collections.shuffle(chooseList);
        result.addAll(chooseList);
        System.out.println(chooseList.size());

        ArrayList<Label> labelList = new ArrayList<>();
        labelList.add(firstName);
        labelList.add(secondName);
        labelList.add(thirdName);
        labelList.add(fourthName);
        labelList.add(fifthName);
        labelList.add(sixthName);

        ArrayList<ImageView> imageList = new ArrayList<>();
        imageList.add(firstImage);
        imageList.add(secondImage);
        imageList.add(thirdImage);
        imageList.add(fourthImage);
        imageList.add(fifthImage);
        imageList.add(sixthImage);

        for (int i = 0; i < labelList.size(); i++) {
            if(chooseList.size() <= i){
                labelList.get(i).setText("");
            }else{
                labelList.get(i).setText(chooseList.get(i).getFoodName());
                imageList.get(i).setImage(new Image(chooseList.get(i).getFoodImage()));
            }
        }
    }

    public void changeView(FoodDTO foodDTO)  {
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
    @FXML
    public void firstView(){
        changeView(result.get(0));
    }
    @FXML
    public void secondView(){
        changeView(result.get(1));
    }
    @FXML
    public void thirdView(){
        changeView(result.get(2));
    }
    @FXML
    public void fourthView(){
        changeView(result.get(3));
    }
    @FXML
    public void fifthView(){
        changeView(result.get(4));
    }
    @FXML
    public void sixthView(){
        changeView(result.get(5));
    }


















}