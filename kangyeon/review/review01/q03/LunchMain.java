package kangyeon.review.review01.q03;

import java.util.ArrayList;
import java.util.Scanner;

public class LunchMain {

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

        System.out.println(lunchMenu);

        Scanner scan = new Scanner(System.in);

        ArrayList<String> randLunch = new ArrayList<>();
        ArrayList<String> randLunch8 = new ArrayList<>();
        ArrayList<String> randLunch4 = new ArrayList<>();
        ArrayList<String> randCheck = new ArrayList<>();

        System.out.println("점심 뭐먹지 ?");

        outer:
        while (true) {
            System.out.println("16강");
            while (true) {
                int rand1 = rand(0, lunchMenu.size() - 1);
                int rand2 = rand(0, lunchMenu.size() - 1);
                if (rand1 == rand2 || randLunch.contains(lunchMenu.get(rand1)) || randLunch.contains(lunchMenu.get(rand2))) {
                    // 아무작업도 안함.
                } else if (randCheck.contains(lunchMenu.get(rand1)) || randCheck.contains(lunchMenu.get(rand2))) {
                    // 아무작업도 안함.
                } else {
                    System.out.println("메뉴를 선택해주세요");
                    System.out.println("1. " + lunchMenu.get(rand1) + " | " + "2. " + lunchMenu.get(rand2));
                    System.out.print(">>> ");
                    int choose = Integer.parseInt(scan.nextLine());
                    randCheck.add(lunchMenu.get(rand1));
                    randCheck.add(lunchMenu.get(rand2));
                    if (choose == 1) {
                        randLunch.add(lunchMenu.get(rand1));
                    } else {
                        randLunch.add(lunchMenu.get(rand2));
                    }
                }
                if (randLunch.size() == 8) {
                    break;
                }
            }
            randCheck.clear();
            System.out.println("8강");
            while (true) {
                int rand1 = rand(0, randLunch.size() - 1);
                int rand2 = rand(0, randLunch.size() - 1);
                if (rand1 == rand2 || randLunch8.contains(randLunch.get(rand1)) || randLunch8.contains(randLunch.get(rand2))) {
                    // 아무작업도 안함.
                } else if (randCheck.contains(randLunch.get(rand1)) || randCheck.contains(randLunch.get(rand2))) {
                    // 아무작업도 안함.
                } else {
                    System.out.println("메뉴를 선택해주세요");
                    System.out.println("1. " + randLunch.get(rand1) + " | " + "2. " + randLunch.get(rand2));
                    System.out.print(">>> ");
                    int choose = Integer.parseInt(scan.nextLine());
                    randCheck.add(randLunch.get(rand1));
                    randCheck.add(randLunch.get(rand2));
                    if (choose == 1) {
                        randLunch8.add(randLunch.get(rand1));
                    } else {
                        randLunch8.add(randLunch.get(rand2));
                    }
                }
                if (randLunch8.size() == 4) {
                    break;
                }
            }
            randCheck.clear();
            System.out.println("4강");
            while (true) {
                int rand1 = rand(0, randLunch8.size() - 1);
                int rand2 = rand(0, randLunch8.size() - 1);
                if (rand1 == rand2 || randLunch4.contains(randLunch8.get(rand1)) || randLunch4.contains(randLunch8.get(rand2))) {
                    // 아무작업도 안함.
                } else if (randCheck.contains(randLunch8.get(rand1)) || randCheck.contains(randLunch8.get(rand2))) {
                    // 아무작업도 안함.
                } else {
                    System.out.println("메뉴를 선택해주세요");
                    System.out.println("1. " + randLunch8.get(rand1) + " | " + "2. " + randLunch8.get(rand2));
                    System.out.print(">>> ");
                    int choose = Integer.parseInt(scan.nextLine());
                    randCheck.add(randLunch8.get(rand1));
                    randCheck.add(randLunch8.get(rand2));
                    if (choose == 1) {
                        randLunch4.add(randLunch8.get(rand1));
                    } else {
                        randLunch4.add(randLunch8.get(rand2));
                    }
                }
                if (randLunch4.size() == 2) {
                    break;
                }
            }
            System.out.println("결승");
            System.out.println("메뉴를 선택해주세요");
            System.out.println("1. " + randLunch4.get(0) + " | " + "2. " + randLunch8.get(1));
            System.out.print(">>> ");
            int choose = Integer.parseInt(scan.nextLine());
            if (choose == 1) {
                System.out.println("오늘 점심은: " + randLunch4.get(0) + "입니다.");
                break outer;
            } else if (choose == 2) {
                System.out.println("오늘 점심은: " + randLunch4.get(1) + "입니다.");
                break outer;
            }
        }



    }
    public static int rand(int a, int b){
        int rand = (int)((Math.random() * (b - a + 1)) + a);
        return  rand;
    }
}
