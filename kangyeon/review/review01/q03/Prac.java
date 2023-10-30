package kangyeon.review.review01.q03;

import java.util.ArrayList;
import java.util.Scanner;

public class Prac {

    public static void main(String[] args) {

        ArrayList<String> lunchMenu = new ArrayList<>();
        lunchMenu.add("짜장면");
        lunchMenu.add("짬뽕");
        lunchMenu.add("볶음밥");
        lunchMenu.add("김치찌개");
        lunchMenu.add("제육볶음");
        lunchMenu.add("돈까스");
        lunchMenu.add("카레");
        lunchMenu.add("김밥/라면");
        lunchMenu.add("순대국밥");
        lunchMenu.add("냉면");
        lunchMenu.add("삼겹살");
        lunchMenu.add("생선구이");
        lunchMenu.add("햄버거");
        lunchMenu.add("떡볶이");
        lunchMenu.add("소고기국밥");
        lunchMenu.add("시래기");

        Scanner scan = new Scanner(System.in);
        ArrayList<String> lunch = new ArrayList<>();
        int num = 16;

        outer:while(true){
            System.out.println(num + "강");
            int randA = rand(0, lunchMenu.size()- 1);
            int randB = rand(0, lunchMenu.size()- 1);
            if(randA == randB){

            }else if(randA != randB){
                System.out.println("메뉴를 선택해주세요");
                System.out.println("1. " + lunchMenu.get(randA) + " | " + "2. " + lunchMenu.get(randB));
                System.out.print(">>> ");
                int choose = Integer.parseInt(scan.nextLine());
                if(choose == 1){
                    lunch.add(lunchMenu.get(randA));
                }else if(choose == 2){
                    lunch.add(lunchMenu.get(randB));
                }
                lunchMenu.remove(randA);
                lunchMenu.remove(randB);
                if(lunchMenu.size() == 8){
                    num /= 2;
                }else if(lunchMenu.size() == 4){
                    num /= 2;
                }
            }













        }


























    }   // 메인 끝
    public static int rand(int a, int b){
        int rand = (int)((Math.random() * (b - a + 1)) + a);
        return  rand;
    }
}
