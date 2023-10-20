package pj01_kangyeon.getarea;

import java.util.ArrayList;
import java.util.Scanner;

import static pj01_kangyeon.getarea.AreaDB.*;

public class AreaMain {

    public static void main(String[] args) {

        AreaDB areas = AreaDB.getInstance();

        Scanner scan = new Scanner(System.in);

        boolean playerTime = true;

        System.out.println("\n" +
                "⠀⠀⠀⠀⠀⠀⢠⡶⠚⠛⠛⠛⠒⠶⠶⠦⣤⣤⣀⣀⣠⡄⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⢸⡇⠠⣦⢼⣇⡴⠃⠀⠀⠀⠀⠈⠉⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⢀⡾⠁⣴⡇⢸⡏⠳⣄⠀⠀⠀⠀⠀⠀⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⢀⡾⠁⠀⢠⡷⢄⣀⠴⣄⠀⠀⠀⠀⠀⠀⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⢸⣅⣀⣀⣀⣀⣈⣋⣀⣀⣀⣀⣀⣀⣀⣀⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠈⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡴⠶⠶⠶⠶⢶⡶⠶⠶⣿⡷⣶⠶⠶⠶⠶⠶⣶⣦\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⣠⡾⠋⠀⠀⠀⣠⡴⠋⠀⠀⠀⣿⡟⠁⠀⠀⠀⣠⣾⠟⣿\n" +
                "⠀⠀⠀⠀⠀⠀⣠⡾⠛⠛⠛⠛⣻⠟⠛⠛⠛⠛⣻⠟⣿⡟⠛⠛⣻⣿⠋⢁⣴⠟\n" +
                "⠀⠀⠀⠀⣠⣞⣉⣀⣀⣀⣠⣞⣁⣀⣀⣀⣠⣞⣁⣀⣙⣁⣴⡾⠋⣿⣴⠟⠁⠀\n" +
                "⠀⢀⣤⠞⠉⠉⠉⢉⡽⠋⠁⠀⠀⢀⡠⠋⠁⠀⠀⢀⣴⣿⠋⢀⣴⠟⠁⠀⠀⠀\n" +
                "⣴⣿⣥⣤⣤⣤⣴⣯⣤⣤⣤⣤⣴⣯⣤⣤⣤⣤⣴⠟⠋⣿⣶⠟⠁⠀⠀⠀⠀⠀\n" +
                "⣿⠉⠉⠉⠉⠉⣿⠉⠉⠉⠉⠉⣿⠉⠉⠉⠉⢹⣿⣠⡾⠛⠁⠀⠀⠀⠀⠀⠀⠀\n" +
                "⢿⣤⣤⣤⣤⣤⣿⣤⣤⣤⣤⣤⣿⣤⣤⣤⣤⣼⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
        );

        outer:
        while (true) {
            System.out.println();
            System.out.println(yellow + "영토 뺏기 게임" + exit);
            System.out.println();
            System.out.println(green + "행동을 선택해주세요." + exit);
            System.out.println(green + "1. 게임하기 | 2. 게임설명 | 3. 종료하기" + exit);
            System.out.println(green + "======================================"+ exit);
            int command = Integer.parseInt(scan.nextLine());
            if (command == 1) {
                String player = "player1";
                System.out.println(green + "게임을 시작합니다."+ exit);
                int score1 = 0;
                int score2 = 0;
                while (true) {
                    if(player.equals("player1")){
                        System.out.println(red + player + exit + green + "님 행동을 선택해주세요." + exit);
                    }else{
                        System.out.println(cyan + player + exit + green + "님 행동을 선택해주세요." + exit);
                    }
                    System.out.println(green + "1. 점령하기 | 2. 필드보기 | 3. 항복하기" + exit);
                    int play = Integer.parseInt(scan.nextLine());
                    if (play == 1) {
                        // 점령하기
                        if (playerTime == true) {
                            System.out.println(red + "player1 " + exit + green + "차례" + exit);
                            System.out.println(green + "점령할 번호를 입력해주세요." + exit);
                            System.out.println();
                            int attack = Integer.parseInt(scan.nextLine());
                            Area temp1 = areas.areaList.get(attack - 1);
                            if (temp1.isMine() == true) {
                                areas.showMine();
                                System.out.println();
                                System.out.println(red + "지뢰를 밟았습니다 ㅋㅋ" + exit);
                                System.out.println(cyan + "player2 " + exit + green + "승리 !!!" + exit);
                                System.out.println(green + "게임이 종료됩니다." + exit);
                                break outer;
                            }
                            if (temp1.getShape().equals(cyan + "\uD83D\uDC99 " + exit)) {
                                int rand = randNum(1, 10);
                                if (rand <= 5) {
                                    temp1.setShape(red + "\uD83E\uDDE1 " + exit);
                                    areas.showField();
                                    System.out.println();
                                    System.out.println(green + attack + "번 지역을 점령하였습니다." + exit);
                                    score1++;
                                    score2--;
                                } else {
                                    areas.showField();
                                    System.out.println();
                                    System.out.println(green + attack + "점령에 " + exit + red + "실패" + exit + green + "했습니다." + exit);
                                }
                            } else {
                                temp1.setShape(red + "\uD83E\uDDE1 " + exit);
                                areas.showField();
                                System.out.println();
                                System.out.println(green + attack + "번 지역을 점령하였습니다." + exit);
                                score1++;
                            }
                            System.out.println(green + "현재 점수 : " + exit + red + "player1= " + score1 + exit + " | "  + cyan + "player2= " + score2 + exit);
                            System.out.println();
                            int a = 0;
                            for (int i = 0; i < areas.areaList.size(); i++) {
                                if ((areas.areaList.get(i).getShape()).equals(red + "\uD83E\uDDE1" + exit)) {
                                    a++;
                                }
                                if (a == 7) {
                                    System.out.println(red + "player1 " + exit + green + "승리 !!!" + exit);
                                    System.out.println(green + "게임이 종료됩니다."+ exit);
                                    break outer;
                                }
                            }
                            playerTime = false;
                            player = "player2";
                        } else if (playerTime == false) {
                            System.out.println(cyan + "player2 " + exit + green + "차례" + exit);
                            System.out.println(green + "점령할 번호를 입력해주세요." + exit);
                            System.out.println();
                            int attack = Integer.parseInt(scan.nextLine());
                            Area temp2 = areas.areaList.get(attack - 1);
                            if (temp2.isMine() == true) {
                                areas.showMine();
                                System.out.println();
                                System.out.println(red + "지뢰를 밟았습니다 ㅋㅋ" + exit);
                                System.out.println(red + "player1 " + exit + green + "승리 !!!" + exit);
                                System.out.println(green + "게임이 종료됩니다." + exit);
                                break outer;
                            }
                            if (temp2.getShape().equals(red + "\uD83E\uDDE1 " + exit)) {
                                int rand = randNum(1, 10);
                                if (rand <= 5) {
                                    temp2.setShape(cyan + "\uD83D\uDC99 " + exit);
                                    areas.showField();
                                    System.out.println();
                                    System.out.println(green + attack + "번 지역을 점령하였습니다." + exit);
                                    score2++;
                                    score1--;
                                } else {
                                    areas.showField();
                                    System.out.println();
                                    System.out.println(green + attack + "점령에 " + exit + red + "실패" + exit + green + "했습니다." + exit);
                                }
                            } else {
                                temp2.setShape(cyan + "\uD83D\uDC99 " + exit);
                                areas.showField();
                                System.out.println();
                                System.out.println(green + attack + "번 지역을 점령하였습니다." + exit);
                                score2++;
                            }
                            System.out.println(green + "현재 점수 = " + exit + red + "player1 " + score1 + exit + green + " : " + exit + cyan + "player2 " + score2 + exit);
                            System.out.println();
                            int b = 0;
                            for (int i = 0; i < areas.areaList.size(); i++) {
                                if ((areas.areaList.get(i).getShape()).equals(cyan + "\uD83D\uDC99 " + exit)) {
                                    b++;
                                }
                                if (b == 7) {
                                    System.out.println(cyan + "player2 " + exit + green + "승리 !!!" + exit);
                                    System.out.println(green + "게임이 종료됩니다." + exit);
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
                        System.out.println(green + "메인 화면으로 돌아갑니다."+ exit);
                        break;

                    } else if (play == 7) { // 히든 지뢰보기 key
                        areas.showMine();
                    }
                }

            } else if (command == 2) {
                System.out.println(green + "======================================"+ exit);
                System.out.println(white + "게임방법: 1~ 25 사이 숫자를 입력하면 숫자에 해당하는 곳을 점령합니다." + exit);
                System.out.println();
                System.out.println(white + "승리방법: 7곳을 먼저 점령하거나 상대가 지뢰를 밟으면 승리 !!" + exit);
                System.out.println();
                System.out.println(white + "* 게임시작 시 점령지에 20% 확률로 지뢰가 생성됩니다." + exit);
                System.out.println();
                System.out.println(white + "* 상대 점령지 공격 시 50% 확률로 영토를 점령합니다." + exit);
                System.out.println(green + "======================================"+ exit);
            } else if (command == 3) {
                System.out.println(green + "게임이 종료됩니다." + exit);
                break;
            }

        }



    }
}





































