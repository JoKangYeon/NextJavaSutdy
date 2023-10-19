package pj01_kangyeon.getarea;

import java.util.ArrayList;
import java.util.Scanner;

import static pj01_kangyeon.getarea.AreaDB.randNum;

public class AreaMain {

    public static void main(String[] args) {

        AreaDB areas = AreaDB.getInstance();

        Scanner scan = new Scanner(System.in);

        boolean playerTime = true;

        outer:while (true) {
            System.out.println("영토 뺏기 게임");
            System.out.println("행동을 선택해주세요.");
            System.out.println("1. 게임하기 | 2. 게임설명 | 3. 종료하기");
            System.out.println("============================================================");
            int command = Integer.parseInt(scan.nextLine());
            if (command == 1) {
                String player = "player1";
                System.out.println("게임을 시작합니다.");

                while (true) {
                    System.out.println(player + "님 헹동을 선택해주세요.");
                    System.out.println("1. 점령하기 | 2. 필드보기 | 3. 항복하기");
                    int play = Integer.parseInt(scan.nextLine());
                    if (play == 1) {
                        // 점령하기
                        if (playerTime == true) {
                            System.out.println("플레이어 1 차례입니다.");
                            System.out.println("점령할 번호를 입력해주세요.");
                            int attack = Integer.parseInt(scan.nextLine());
                            if((areas.areaList.get(attack-1).isMine() == true)){
                                System.out.println("지뢰를 밟았습니다 ㅋㅋ");
                                System.out.println("플레이어 2 승리 !!!");
                                System.out.println("게임이 종료됩니다.");
                                break outer;
                            }
                            if((areas.areaList.get(attack-1).getShape().equals("P2"))){
                                int rand = randNum(1, 10);
                                if(rand <= 5){
                                    areas.areaList.get(attack-1).setShape("P1");
                                    System.out.println(attack + "을 점령하였습니다.");
                                }else{
                                    System.out.println(attack + "점령에 실패했습니다.");
                                }
                            }else{
                                areas.areaList.get(attack-1).setShape("P1");
                                System.out.println(attack + "을 점령하였습니다.");
                            }
                            int a = 0;
                            for(int i = 0; i < areas.areaList.size(); i++){
                                if((areas.areaList.get(i).getShape()).equals("P1")){
                                    a++;
                                }
                                if(a == 7){
                                    System.out.println("플레이어 1 승리 !!!");
                                    System.out.println("게임이 종료됩니다.");
                                    break outer;
                                }
                            }
                            playerTime = false;
                            player = "player2";
                        } else if (playerTime == false) {
                            System.out.println("플레이어 2 차례입니다.");
                            System.out.println("점령할 번호를 입력해주세요.");
                            int attack = Integer.parseInt(scan.nextLine());
                            if((areas.areaList.get(attack-1).isMine() == true)){
                                System.out.println("지뢰를 밟았습니다 ㅋㅋ");
                                System.out.println("플레이어 1 승리 !!!");
                                System.out.println("게임이 종료됩니다.");
                                break outer;
                            }
                            if((areas.areaList.get(attack-1).getShape().equals("P1"))){
                                int rand = randNum(1, 10);
                                if(rand <= 5){
                                    areas.areaList.get(attack-1).setShape("P2");
                                    System.out.println(attack + "을 점령하였습니다.");
                                }else{
                                    System.out.println(attack + "점령에 실패했습니다.");
                                }
                            }else{
                                areas.areaList.get(attack-1).setShape("P2");
                                System.out.println(attack + "을 점령하였습니다.");
                            }
                            int b = 0;
                            for(int i = 0; i < areas.areaList.size(); i++){
                                if((areas.areaList.get(i).getShape()).equals("P2")){
                                    b++;
                                }
                                if(b == 7){
                                    System.out.println("플레이어 2 승리 !!!");
                                    System.out.println("게임이 종료됩니다.");
                                    break outer;
                                }
                            }
                            playerTime = true;
                            player = "player1";
                        }
                    } else if (play == 2) {
                        // 필드보기
                        areas.showField();


                    } else if (play == 3) {
                        // 항복하기
                        System.out.println("메인 화면으로 돌아갑니다.");
                        break;

                    }else if(play == 7){
                        int a = 0;
                        for(int i = 0; i < 5; i ++){
                            for(int j = 0; j < 5; j++){
                                System.out.print(areas.areaList.get(a).isMine());
                                a++;
                            }
                            System.out.println();
                        }
                    }
                }

            } else if (command == 2) {
                System.out.println("============================================================");
                System.out.println("게임방법: 1~ 25 사이 숫자를 입력하면 숫자에 해당하는 곳을 점령합니다.");
                System.out.println("승리방법: 7곳을 먼저 점령하거나 상대가 지뢰를 밟으면 승리 !!");
                System.out.println("* 게임시작 시 점령지에 20% 확률로 지뢰가 생성됩니다.");
                System.out.println("* 상대 점령지 공격 시 50% 확률로 영토를 점령합니다.");
                System.out.println("============================================================");
            } else if (command == 3) {
                System.out.println("게임이 종료됩니다");
                break;
            }


        }



    }
}






































