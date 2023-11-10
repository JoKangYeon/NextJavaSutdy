package com.example.lottoshop.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class UtilClass {

    // 로또 생성 메소드
    // 6자리의 랜덤 숫자를 담은 ArrayList 리턴

    public static ArrayList<Integer> getLottoList(){
        HashSet<Integer> tempSet = new HashSet<>();
        while(tempSet.size() < 6){
            tempSet.add((int)(Math.random()*45)+1);
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.addAll(tempSet);
        Collections.sort(result);
        return result;

    }


}
