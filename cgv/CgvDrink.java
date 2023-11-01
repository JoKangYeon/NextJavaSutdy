package cgv;

import java.util.ArrayList;

public class CgvDrink {

    private ArrayList<Drink> drinkList = new ArrayList<>();

    private CgvDrink() {
        drinkList.add(new Drink("콜라", 3000, true));
        drinkList.add(new Drink("사이다", 2800, true));
        drinkList.add(new Drink("환타", 2500, true));
        drinkList.add(new Drink("제로콜라", 2000, false));
        drinkList.add(new Drink("제로사이다", 2000, false));
    }
    private static CgvDrink instance = new CgvDrink();

    public static CgvDrink getInstance() {
        return instance;
    }

    // 음료 목록보기 메소드
    public void showDrinkList(){
        for(Drink dr : drinkList){
            System.out.println(dr);
        }
    }

    @Override
    public String toString() {
        return "CgvDrink{" +
                "drinkList=" + drinkList +
                '}';
    }
}
