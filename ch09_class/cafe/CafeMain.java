package ch09_class.cafe;

import java.util.Scanner;

public class CafeMain {
    public static void main(String[] args) {
        // 카페: 콘테, 스타벅스, ...
        // 음료: 아메리카노, 라떼, 아이스티, ...

        Cafe conte = new Cafe("콘테");
        // Cafe 객체는 Coffee 객체를 menu에 추가할 수 있다 -> 메소드화
        conte.getMenu().add(new Coffee("아메리카노", 2000));
        conte.addCoffee(new Coffee("카페라떼", 4000));
        conte.addCoffee(new Coffee("레몬티", 5000));


        Cafe starbucks = new Cafe("스타벅스");

        starbucks.addCoffee(new Coffee("아메리카노", 4500));
        starbucks.addCoffee(new Coffee("초코라떼", 5500));
        starbucks.addCoffee(new Coffee("녹차라떼", 7000));

        Scanner scan = new Scanner(System.in);

        while(true){
            System.out.println("행동을 선택해주세요.");
            System.out.println("1. 스타벅스 | 2. 콘테 | 3. 사무실 복귀..");
            System.out.print(">>> ");

            int command = Integer.parseInt(scan.nextLine());

            if(command == 1){
                // 스타벅스 방문
                // 메뉴판이 출력되고 메뉴 선택 -> 메소드화
                starbucks.printMenu();
                System.out.print("메뉴 선택(번호): ");
                int select = Integer.parseInt(scan.nextLine());
                starbucks.selectMenu(select);
            }else if(command == 2){
                // 콘테 방문
                // 메뉴판이 출력되고 메뉴 선택
                conte.printMenu();
                System.out.print("메뉴 선택(번호): ");
                int select = Integer.parseInt(scan.nextLine());
                conte.selectMenu(select);
            }else{
                System.out.println("사무실로 복귀합니다..");
                break;
            }






        }

















    }
}
