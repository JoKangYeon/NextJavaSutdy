package ch08_collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CollectionSet {
    public static void main(String[] args) {
        // Set은 우리가 직접적으로 만들어서 사용하는 경우는 드뭄
        // (like 배열)
        // 하지만 사용법은 잘 알아두어야 한다.

        // 집합(Set -> HashSet)의 선언
        HashSet<String> stuSet = new HashSet<String>();
        HashSet<String> stuSet2 = new HashSet<String>();

        // 다형성 이용
        Set<String> stuSet3 = new HashSet<>();

        // .add() 값을 추가
        stuSet.add("유민");
        stuSet.add("민재");
        stuSet.add("강연");
        stuSet.add("태곤");

        // 값 확인
        // 담고 있는 데이터에 인데스 및 순서가 존재하지 않는다.
        System.out.println(stuSet);

        // 중복된 값이 들어가지 않는다.
        stuSet.add("태곤");
        System.out.println(stuSet);

        System.out.println("\n==============================================\n");

        // .contains(객체)
        // 해당 객체가 Set 안에 있으면 true, 없으면 false
        System.out.println(stuSet.contains("태곤"));

        // .size()
        // Set 내부 요소 개수 리턴
        System.out.println(stuSet.size());

        System.out.println("\n==============================================\n");

        // Set 내부 요소 순회

        // 1. While문 사용
        Iterator<String> iterator = stuSet.iterator();
        while(iterator.hasNext()){
            String stu = iterator.next();
            System.out.println(stu);
        }

        // 2. 향상된 for문 사용
        for( String stu : stuSet ){
            System.out.println(stu);
        }

        // 3. forEach문 사용
        stuSet.forEach(stu -> {
            System.out.println(stu);
        });

        System.out.println("\n==============================================\n");

        // Set의 중복을 허용하지 않는 특성을 이용한
        // 중복제거

        ArrayList<Integer> intList = new ArrayList<>();

        // 랜덤숫자 10번 담기
        // = 랜덤숫자를 생성하면서 담는행동 10번 반복
        for(int i = 0; i < 10; i++){
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
        System.out.println(intList);

        HashSet<Integer> intSet = new HashSet<>();
        // intList 내부요소들이 intSet에 담김
        intSet.addAll(intList);
        System.out.println(intSet); // 중복된 데이터는 하나만 남게됨

        intList.clear();
        // intSet 내부 요소들이 intList에 담김
        intList.addAll(intSet);
        System.out.println(intList); // 순서는 망가져 있다.

    }
}
