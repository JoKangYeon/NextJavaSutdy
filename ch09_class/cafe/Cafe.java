package ch09_class.cafe;

import java.util.ArrayList;

public class Cafe {

    private String name;                // 카페명
    private ArrayList<Coffee> menu;     // 음료 목록


    public Cafe(String name) {
        this.name = name;
        menu = new ArrayList<>();   // 입력값을 받기 까다로워서? 따로 받는걸로 추정
    }


    // 메뉴에 커피 객체 추가 메소드
    public void addCoffee(Coffee coffee){
        menu.add(coffee);
    }

    // 메뉴판 출력 (중복코드를 최소화 하기 위해 작은 단위로 메소드를 선언)
    public void printMenu(){
        for(int i = 0; i < menu.size(); i++){
            System.out.println(i+1 + ". " + menu.get(i));
        }
    }

    // 메뉴선택 후 구입
    public void selectMenu(int select){
        String name = menu.get(select-1).getName();
        int price = menu.get(select-1).getPrice();
        System.out.println(name + "을 " + price + "원에 구매하였습니다.");
    }












    public String getName() {
        return name;
    }

    public ArrayList<Coffee> getMenu() {
        return menu;
    }


}

