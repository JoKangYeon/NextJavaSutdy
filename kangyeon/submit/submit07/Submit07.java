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
                    intList.remove(k);
                    i--;
                }
            }
        }
        System.out.println(intList);

        Collections.sort(intList);
        System.out.println(intList);

        intList.sort(Collections.reverseOrder());
        System.out.println(intList);



//        아내가 사고 싶은 물건  ["냉장고", "로봇청소기", "세탁기", "에어컨"] 을 리스트에 담아주세요.
//
//                남편이 사고 싶은 물건 ["노트북", "TV", "에어컨", "플레이스테이션", "로봇청소기"] 을 다른 리스트에 담아주세요.
//
//
//        1. 서로 사고 싶은 물건 목록을 새로운 리스트에 담아 콘솔에 출력해주세요(교집합)

        ArrayList<String> wifeWishList = new ArrayList<>();

        wifeWishList.add("냉장고");
        wifeWishList.add("로봇청소기");
        wifeWishList.add("세탁기");
        wifeWishList.add("에어컨");

        ArrayList<String> husWishList = new ArrayList<>();

        husWishList.add("노트북");
        husWishList.add("TV");
        husWishList.add("에어컨");
        husWishList.add("플레이스테이션");
        husWishList.add("로봇청소기");

        ArrayList<String> comWishList = new ArrayList<>();

        for(int i = 0; i < wifeWishList.size(); i++){
            for(int j = 0; j < husWishList.size(); j++){
                if(wifeWishList.get(i) == husWishList.get(j)){
                    comWishList.add(wifeWishList.get(i));
                }
            }
        }
        System.out.println(comWishList);

//        2. 사고 싶은걸 다 산다고 했을때의 구매 목록을 새로운 리스트에 담아 콘솔에 출력해주세요(합집합)

        ArrayList<String> evyWishList = new ArrayList<>();

        for(int i = 0; i < wifeWishList.size(); i++){
            evyWishList.add(wifeWishList.get(i));
        }
        for(int i = 0; i < husWishList.size(); i++){
                if(evyWishList.contains(husWishList.get(i))){
                    evyWishList.add(husWishList.get(i));
                    break;
                }
        }

        System.out.println(evyWishList);





    }
}
