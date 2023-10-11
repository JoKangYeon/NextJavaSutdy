package kangyeon.submit.submit07;

import java.util.ArrayList;
import java.util.Collections;

public class Submit07 {
    public static void main(String[] args) {

        // remove 사용
        // 정수를 담을 수 있는 ArrayList 선언
        ArrayList<Integer> intList = new ArrayList<>();

        // 랜덤숫자 10번 담기
        // = 랜덤숫자를 생성하면서 담는행동 10번 반복
       /* for(int i = 0; i < 10; i++){
            // (int)(Math.random() * (b - a + 1) + a : a ~ b 사이의 정수
           intList.add((int)(Math.random() * 11) + 10);
        }
        System.out.println(intList);

        System.out.println("\n=====================================================\n");

        for(int i = 0; i < intList.size(); i++){
            for(int k = intList.size()-1; k > i; k--){
                if(intList.get(i) == intList.get(k)){
                    intList.remove(k);
                }
            }
        }
        System.out.println(intList);*/

        ArrayList<Integer> newList = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            // (int)(Math.random() * (b - a + 1) + a : a ~ b 사이의 정수
            intList.add((int)(Math.random() * 11) + 10);
        }
        System.out.println(intList);

        //intList를 순회하는 for문
        for(int i = 0; i < intList.size(); i++){

            // newList에 intList의 값을 옮긴다.
            // 값을 옮길때 newList 안에 intList.get(i)의 값이 존재하는지 체크
            // 존재하지 않을때만 옮긴다.
            if(newList.contains(intList.get(i)) == false){
                // 값이 존재함
                newList.add(intList.get(i));
            }
        }
        System.out.println(newList);


        Collections.sort(newList);
        System.out.println(newList);

        newList.sort(Collections.reverseOrder());
        System.out.println(newList);



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
                if(!evyWishList.contains(husWishList.get(i))){
                    evyWishList.add(husWishList.get(i));
                }
        }

        System.out.println(evyWishList);

        ArrayList<String> wantAll = new ArrayList<>();
        for(int i = 0; i < wantAll.size(); i++){
            wantAll.add(wifeWishList.get(i));
        }

        // wantAll.addAll(wifeList); 와 같다.
        for(int i = 0; i < husWishList.size(); i++){
            husWishList.get(i);
            // husList.get(i) 의 값이 wantAll 안에 없어야 추가
            boolean isContain = false;
            for(int k = 0; k < wantAll.size(); k++){
                if(wantAll.get(k).equals(husWishList) == true){
                    isContain = true;
                }
            }
            // isContain 값이 false일때 husList.get(i) 를 wantAll에 추가
            if(isContain == false){
                wantAll.add(husWishList.get(i));
            }
        }
        System.out.println(wantAll);







    }
}
