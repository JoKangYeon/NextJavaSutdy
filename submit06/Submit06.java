package submit06;

import java.util.Arrays;

public class Submit06 {

    public static void main(String[] args) {

        // 한국 배우들의 명단을 배열로 만들어보았습니다.
        // for문을 이용하여 "이"씨 성을 가진 사람이 몇명인지 출력


        String[] nameList = {"이정재", "김혜수", "이병헌", "송중기", "유아인", "류준열", "공유", "마동석", "이종석",
                "황정민", "박소담", "이선균", "이성민", "최민식", "이동휘", "권상우", "소지섭", "공효진", "조정석", "허성태", "이하늬"};

        int count = 0; // 이씨 성인 배우 수
        for (int i = 0; i < nameList.length; i++) {
            for (int k = 0; k < 1; k++) {
                if ((nameList[i].substring(k, k + 1).equals("이"))) {
                    count += 1;
                }
            }
        }
        System.out.println("이씨 성을 가진 배우가 층 " + count + "명 있습니다.");

      /*  for(int i = 0; i < nameList.length; i++){
            if ((nameList[i].substring(0, 1).equals("이"))) {
                count += 1;
            }
            }
        }*/



//      int[] intArr = {23, 456, 213, 32, 464, 1, 2, 4};
//      for문을 이용해 intArr의 최댓값과 최솟값을 출력

        int[] intArr = {23, 456, 213, 32, 464, 1, 2, 4};

        int maxnum = intArr[0];
        int minnum = intArr[0];
        for (int i = 0; i < intArr.length; i++) {
            if (maxnum < intArr[i]) {
                maxnum = intArr[i];
            } else if (minnum > intArr[i]) {
                minnum = intArr[i];
            }
        }
        System.out.println("최댓값: " + maxnum);
        System.out.println("최솟값: " + minnum);

       // Arrays.sort(intArr); //오름차순 정렬


        // 1~45 까지의 랜덤 숫자 6개를 배열에 중복되지 않도록 담고,
        // 이를 정렬한 배열을 리턴하는 makeLotto() 함수를 만들어주세요.

        int[] myLotto = makeLotto();
        for(int i = 0; i < myLotto.length; i++){
            System.out.print(myLotto[i] + " ");
        }

       /* int[] numArr = new int[6];
        int idx = 0;

        while(true){
            // 랜덤 숫자 생성
            int rand = (int)(Math.random()*45) + 1;
            // 랜덤 숫자가 현재 배열 내 존재하는지 체크
            boolean isDuple = false;
            for(int i = 0; i < numArr.length; i++){
                if(numArr[i] == rand){
                    // 랜덤 숫자가 현재 배열에 존재함
                    isDuple = true;
                }
            }
            // 위 for문이 끝날때까지 if문이 단 한번이라도 실행이 되었는지 체크
            // isDuple이 false일때 rand를 배열에 담기
            if(!isDuple){
                numArr[idx] = rand;
                idx++;
            }

            if(idx == 6){
                break;
            }
        }*/







    } // 메인 끝

    public static int[] makeLotto(){

        int[] myLotto = new int[6];

        // 인덱스 6인 배열 선언
        // 1~45 숫자 추출
        // 중복값 제거
        // 새로 나온 값이 앞에 나온 값과 같은 경우 재실행

        for (int i = 0; i < myLotto.length; i++) {
            myLotto[i] = (int) (Math.random() * 45) + 1;
            for (int j = 0; j < i; j++) {
                if (myLotto[i] == myLotto[j]) {
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(myLotto);
        return myLotto;
    }

    //








}
