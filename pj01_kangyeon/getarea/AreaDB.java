package pj01_kangyeon.getarea;

import kangyeon.submit.submit10.Book;

import java.util.ArrayList;

public class AreaDB {

    ArrayList<Area> areaList = new ArrayList<>();

    private  AreaDB(){
        for(int i = 0; i < 25; i++){
            areaList.add(new Area((i+1), false, "ㅁ"));

            int minePercent = (int)(Math.random()*10);
            if(minePercent < 2){
                areaList.get(i).setMine(true);
            }else if(minePercent > 1){
                areaList.get(i).setMine(false);
            }
        }
    }

    private static AreaDB instance = new AreaDB();

    public static AreaDB getInstance() {return instance;}


    // 랜덤숫자 뽑기 메소드
    public static int randNum(int a, int b){
        return (int)(Math.random() * (b - a + 1)) + a;
    }

    // 필드보기 메소드

    public void showField(){
        int a = 0;
        for(int i = 0; i < 5; i ++){
            for(int j = 0; j < 5; j++){
                System.out.print(areaList.get(a).getShape());
                a++;
            }
            System.out.println();
        }
    }



    // 지뢰보기 메소드








}
