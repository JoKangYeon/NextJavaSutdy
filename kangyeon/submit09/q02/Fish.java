package kangyeon.submit09.q02;

public class Fish {

    String fishName;    /*물고기 이름*/
    int fishPrice;      /*물고기 싯가*/

    // 기본생성자
    Fish(){

    }

    // 파라미터 입력받는 생성자


    Fish(String fishName, int fishPrice){
        this.fishName = fishName;
        this.fishPrice = fishPrice;
        /* this(fishName, fishPrice);*/  // 이거는 왜 안될까....
    }

    @Override
    public String toString() {
        return "[" +
                fishName +
                ", 가치: " + fishPrice +
                ']';
    }

}
