package pj01_kangyeon.getarea;

import kangyeon.submit.submit10.Book;

import java.util.ArrayList;

public class AreaDB {

        ArrayList<Area> areaList = new ArrayList<>();

        private  AreaDB(){
            for(int i = 0; i < 25; i++){
                areaList.add(new Area((i+1), false, white + "⏹ " + exit));

                int minePercent = (int)(Math.random()*10);
                if(minePercent < 1){
                    areaList.get(i).setMine(true);
                }else if(minePercent > 0){
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
        public void showMine(){
            int a = 0;
            for(int i = 0; i < 5; i ++){
                for(int j = 0; j < 5; j++){
                    boolean tf = areaList.get(a).isMine();
                    String changeSharp = tf ? red +"\uD83C\uDF9B " + exit : green + "⏺ " + exit;;
                    System.out.print(changeSharp);
                    a++;
                }
                System.out.println();
            }
        }

    public static final String black    = "\u001B[30m" ;
    public static final String red      = "\u001B[31m" ;
    public static final String green    = "\u001B[32m" ;
    public static final String yellow   = "\u001B[33m" ;
    public static final String blue     = "\u001B[34m" ;
    public static final String purple   = "\u001B[35m" ;
    public static final String cyan     = "\u001B[36m" ;
    public static final String white     = "\u001B[37m" ;

    public static final String exit     = "\u001B[0m" ;


}
