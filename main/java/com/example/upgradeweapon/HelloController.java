package com.example.upgradeweapon;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class HelloController {
    // fxml 파일 내에 id가 welcomText인 Label 태그 요소가
    // 자동으로 불러와서 담김
    @FXML
    private Label percent;

    @FXML
    private Label upgrade;

    @FXML
    private ImageView weaponImage;

    @FXML
    private Button btn;

    @FXML
    private VBox container;

    @FXML
    private Label money;

    @FXML
    private Label cost;     /* 무기강화비용 */

    @FXML
    private Label price;    /* 수익강화비용 */

    // 초기 무기 레벨은 1
    private int level = 1;

    // 초기 강화 성공률은 100%
    private int success = 100;

    // 최대 강화 도달시 true
    private boolean isMax = false;

    // 소지금
    private int _money = 1000;

    // 무기강화비용
    private int _cost = 100;

    // 수익강화비용
    private int _price = 500;

    // 수익강화 수치
    private int incomeLevel = 0;

    // 어플리케이션 실행 여부
    private boolean isRun = true;


    // 강화 버튼 클릭시 실행되는 메소드
    @FXML
    protected void onUpgradeButtonClick() {
        // isMax가 true면 메소드 즉시 종료
        if(isMax){
            return;
        }

        // 소지금이 강화비용보다 적으면 강화진행 X
        if(_money < _cost){
            return;
        }

        // 소지금을 강화비용만큼 깎기
        _money -= _cost;
        money.setText(_money + "");

        // 강화 성공 확률에 따른 무기 레벨 업
        int rand = (int)(Math.random() * 100) + 1;
        int rand2 = (int)(Math.random() * 100) + 1;

        // level 이 25에 도달하면 max 로 표기 + 더이상 강화 못함
        // 매번 강화시 5% 확률로 무기가 파괴된다 -> 1강, weapon01.png로 초기화
        if(rand2 <= 5){
            level = 1;
            success = 100;
            upgrade.setText("+1강");
            percent.setText("100%강");
            Image img = new Image(getClass().getResource("/images/weapon01.png").toString());
            weaponImage.setImage(img);
            return;
        }

        if(rand <= success){
            // 강화 성공시 무기 레벨 업!!
            level++;
        }else{
            // 강화 실패시 무기 레벨 다운!!
            // 5강, 10강, 15강, 20강일때에는 강화 실패시 유지시켜줌(하락x)
            if( !(level % 5 == 0) ){
                level--;
            }
        }

        // level 이 10 이상이 되면 weapon02.png 로 변경
        // 20 이상이 되면 weapon03.png 로 변경
        if(level >= 10 && level < 20){
            // ImageView 내부 이미지 변경
            Image img = new Image(getClass().getResource("/images/weapon02.png").toString());
            weaponImage.setImage(img);
        }else if(level >= 20){
            Image img = new Image(getClass().getResource("/images/weapon03.png").toString());
            weaponImage.setImage(img);
        }

        if(level < 25){
            // 강화 후 level을 화면에 보여주기
            upgrade.setText("+" + level + "강");

            // level이 올라가면 강화성공 확률이 감소한다.
            // Lv 1 : 100%, Lv 2 : 97%, Lv 3 : 94%, ...
            // level에 따른 성공확률 적용
            success = 100 - ((level-1)*2);

            // 화면에 성공확률 보여주기
            percent.setText("성공확률: " + success + "%");

            // level이 올라가면 강화비용(_cost)가 증가한다.
            _cost = 100 + (50 * level);
            cost.setText("무기강화비용: " + _cost);

        }else{
            // level이 25강 됨
            // 이때까지 쓴 총 금액 보여주기
            upgrade.setText("MAX !!");
            percent.setText("최대 강화수치 도달");
            isMax = true;

            // 강화 버튼을 지우기
            // 1. 버튼을 보이지 않게 만들기
            btn.setVisible(false);

            // 2. Container 내에서 버튼 제거
            container.getChildren().remove(btn);
        }


    }

    // 수익 증가 버튼 클릭
    @FXML
    public void onIncomeButtonClick(){
        // 수익강화비용이 소지금보다 클때에만 수익강화 진행
        if(_money < _price){
            return;
        }

        // 소지금 - 수익강화비용
        _money -= _price;
        money.setText(_money + "");

        // 수익강화
        incomeLevel++;

        // 수익강화비용 증가
        _price += 500;
        price.setText("수익강화비용: " + _price);
    }

    // 자동으로 돈이 오르도록 외부 스레드에게 일을 시킴
    // 어플리케이션이 실행 되자마자 자동으로 autoIncome() 메소드가
    // 실행되어야 한다. -> HelloApplication ㄱㄱ
    public void autoIncome(){

        Thread scv = new Thread( () -> {
            // 어플리케이션을 종료하더라도, 외부 스레드는 while을 무한 반복실행하고있다.
            // 어플리케이션 종료시, while문을 종료 필요
            while(isRun){
                _money += 100 + (incomeLevel * 50);

                // UI 변경 명령어는 main 스레드에서만 가능
                // 아래의 추상메소드 내부 코드는 main 스레드에서 실행
                Platform.runLater( () -> {
                    money.setText(_money + "");
                });

                try {
                    // 0.5 초 마다 소지금 증가
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        scv.start();
    }

    // HelloApplication 의 stop 메소드에서 실행시킴
    public void stopThread(){
        isRun = false;
    }

}