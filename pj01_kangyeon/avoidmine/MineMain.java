package pj01_kangyeon.avoidmine;

import java.util.ArrayList;
import java.util.Scanner;

import static pj01_kangyeon.avoidmine.Field.printArray;
import static pj01_kangyeon.avoidmine.Field.randNum;

public class MineMain {

    public static void main(String[] args) {

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

        Scanner scan = new Scanner(System.in);

        String[][] field = {{"1  ", "2  ", "3  ", "4  ", "5"}, {"6  ", "7  ", "8  ", "9  ", "10"}
                , {"11  ", "12  ", "13  ", "14  ", "15  "}, {"16  ", "17  ", "18  ", "19  ", "20"}, {"21  ", "22  ", "23  ", "24  ", "25"}};

        Field mineField = Field.getInstance();







        // 플레이어 차례 확인 변수
 /*       boolean playerTimne = true;

        while (true) {
            System.out.println("영토 뺏기 게임");
            System.out.println("행동을 선택해주세요.");
            System.out.println("1. 게임하기 | 2. 게임설명 | 3. 종료하기");
            System.out.println("============================================================");
            int command = Integer.parseInt(scan.nextLine());
            if (command == 1) {
                String player = "player1";
                System.out.println("게임을 시작합니다.");

                // 시작과 동시에 랜덤 지뢰 생성
             *//*   int random = randNum(4, 6);

                for (int i = 0; i < random; i++) {
                    int a = randNum(0, 4);
                    int b = randNum(0, 4);
                    if (mineField[a][b].equals("지뢰")) {
                        i--;
                    } else {
                        mineField[a][b] = "지뢰";
                    }
                }
*//*
                while (true) {
                    System.out.println(player + "님 헹동을 선택해주세요.");
                    System.out.println("1. 점령하기 | 2. 필드보기 | 3. 항복하기");
                    int play = Integer.parseInt(scan.nextLine());
                    if (play == 1) {
                        // 점령하기
                        if (playerTimne == true) {
                            System.out.println("점령할 번호를 입력해주세요.");
                            int attack = Integer.parseInt(scan.nextLine());
                            if (attack <= 5) {
                                field[0][attack - 1] = "P1";
                            } else if (attack <= 10) {
                                field[1][attack - 6] = "P1";
                            } else if (attack <= 15) {
                                field[2][attack - 11] = "P1";
                            } else if (attack <= 20) {
                                field[3][attack - 16] = "P1";
                            } else if (attack <= 25) {
                                field[4][attack - 21] = "P1";
                            }
                            playerTimne = false;
                            System.out.println(attack + "을 점령하였습니다.");
                            player = "player2";
                        } else if (playerTimne == false) {
                            System.out.println("점령할 번호를 입력해주세요.");
                            int attack = Integer.parseInt(scan.nextLine());
                            if (attack <= 5) {
                                field[0][attack - 1] = "P2";
                                playerTimne = true;
                            } else if (attack <= 10) {
                                field[1][attack - 6] = "P2";
                                playerTimne = true;
                            } else if (attack <= 15) {
                                field[2][attack - 11] = "P2";
                                playerTimne = true;
                            } else if (attack <= 20) {
                                field[3][attack - 16] = "P2";
                                playerTimne = true;
                            } else if (attack <= 25) {
                                field[4][attack - 21] = "P2";
                            }
                            playerTimne = true;
                            System.out.println(attack + "을 점령하였습니다.");
                            player = "player1";
                        }

                    } else if (play == 2) {
                        // 필드보기
                        for (int i = 0; i < field.length; i++) {
                            printArray(field[i]);
                        }

                    } else if (play == 3) {
                        // 항복하기
                        System.out.println("메인 화면으로 돌아갑니다.");
                        break;

                    }
                }

            } else if (command == 2) {
                System.out.println("============================================================");
                System.out.println("게임방법: 1~ 25 사이 숫자를 입력하면 숫자에 해당하는 곳을 점령합니다.");
                System.out.println("승리방법: 7곳을 먼저 점령하거나 상대가 지뢰를 밟으면 승리 !!");
                System.out.println("* 게임시작 시 4~6개의 지뢰가 랜덤 생성됩니다.");
                System.out.println("* 상대 점령지 번호 입력 시 20% 확률로 영토를 점령합니다.");
                System.out.println("============================================================");
            } else if (command == 3) {
                System.out.println("게임이 종료됩니다");
                break;
            }


        }*/


    }
}
