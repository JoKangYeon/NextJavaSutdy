package kangyeon.submit.submit07;

import java.util.ArrayList;
import java.util.Collections;

public class Submit07 {
    public static void main(String[] args) {
        // 정수를 담을 수 있는 ArrayList 선언
        ArrayList<Integer> intList = new ArrayList<>();

        // 랜덤숫자 10번 담기
        // = 랜덤숫자를 생성하면서 담는행동 10번 반복
        for(int i = 0; i < 10; i++){
           intList.add((int)(Math.random() * 20) + 10);
        }
        System.out.println(intList);

        ArrayList<Integer> numList = new ArrayList<>();
        for(int i = 0; i < intList.size()-1; i++){
            for(int k = 0; k < i; k++){
                if(intList.get(i) == intList.get(k)){
                    intList.remove(i);
                    i--;
                }
            }
        }
        System.out.println(intList);

        Collections.sort(intList);
        System.out.println(intList);

        intList.sort(Collections.reverseOrder());
        System.out.println(intList);







    }
}
