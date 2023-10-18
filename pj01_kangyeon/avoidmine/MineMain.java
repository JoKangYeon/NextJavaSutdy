package pj01_kangyeon.avoidmine;

import java.util.ArrayList;
import java.util.Scanner;

import static pj01_kangyeon.avoidmine.Field.printArray;

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

        String[][] field = {{"①  ", "②  ", "③  ", "④  ", "⑤"}, {"⑥  ", "⑦  ", "⑧  ", "⑨  ", "⑩"}
                , {"⑪  ", "⑫  ", "⑬  ", "⑭  ", "⑮  "}, {"⑯  ", "⑰  ", "⑱  ", "⑲  ", "⑳"}, {"㉑  ", "㉒  ", "㉓  ", "㉔  ", "㉕"}};

       /* for (int i = 0; i < field.length; i++) {
            printArray(field[i]);
        }*/


        while (true) {
            System.out.println("영토 뺏기 게임");
            System.out.println("행동을 선택해주세요.");
            System.out.println("1. 게임하기 | 2. 게임설명 | 3. 종료하기");
            int command = Integer.parseInt(scan.nextLine());
            if(command == 1){
                while(true){
                    System.out.println("게임을 시작합니다.");
                    System.out.println("Player1 헹동을 선택해주세요.");
                    System.out.println("1. 점령하기 | 2. 필드보기 | 3. 항복하기");
                    int play = Integer.parseInt(scan.nextLine());
                    if(play == 1){
                        // 점령하기
                        System.out.println("==============================");
                        System.out.println("점령할 번호를 입력해주세요.");
                        int attack = Integer.parseInt(scan.nextLine());
                        if(attack <= 5){
                           field[1][0 + attack] = "P1";
                        }else if(attack <= 10){
                            field[1][attack - 5] = "P1";
                        }else if(attack <= 15){
                            field[1][attack - 10] = "P1";
                        }else if(attack <= 20){
                            field[1][attack - 15] = "P1";
                        }else if(attack <= 25){
                            field[1][attack - 20] = "P1";
                        }



                    }else if(play == 2){
                        // 필드보기
                        for (int i = 0; i < field.length; i++) {
                            printArray(field[i]);
                        }

                    }else if(play == 3){
                        // 항복하기
                        System.out.println("메인 화면으로 돌아갑니다.");
                        break;

                    }




                }


            }else if(command == 2){
                System.out.println("게임방법: 1~ 25 사이 숫자를 입력하면 숫자에 해당하는 곳을 점령합니다");
                System.out.println("승리방법: 7곳을 먼저 점령하거나 상대가 지뢰를 밟으면 승리 !!");
                System.out.println("* 게임시작 시 3~5개의 지뢰가 랜덤 생성됩니다.");
                System.out.println("* 상대 점령지 번호 입력 시 20% 확률로 영토를 점령합니다.");
            }else if(command == 3){
                System.out.println("게임이 종료됩니다");
                break;
            }











        }

    }
}
