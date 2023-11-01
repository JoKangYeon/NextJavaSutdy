package cgv;

import java.util.ArrayList;

public class CgvFood {
    private ArrayList<Food> foodList = new ArrayList<>();

    private CgvFood() {
        foodList.add(new Food("기본팝콘", 5000, "Regular"));
        foodList.add(new Food("기본팝콘", 5500, "Large"));
        foodList.add(new Food("카라멜팝콘", 6000, "regular"));
        foodList.add(new Food("초코팝콘", 7000, "regular"));
        foodList.add(new Food("버터오징어", 8000, "1box"));
    }

    private static CgvFood instance = new CgvFood();

    public static CgvFood getInstance() {
        return instance;
    }

    // 음식목록보기 메소드
    public void showFoodList(){
        for(int i = 0; i < foodList.size(); i++){
            System.out.println(foodList.get(i));
        }
    }

    // 음식목록보기 메소드 (향상된for문)
    /*public void showFoodList2(){
        for(Food fo : foodList){
            System.out.println(fo);
        }
    }*/


}
