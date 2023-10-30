package kangyeon.submit08;

import java.util.*;

public class Submit08 {

    public static void main(String[] args) {

      /*  ArrayList<Integer> intSet = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<String>();
        int a = 0;

        while (true) {
            for (int i = 0; i < 6; i++) {
                int rand = (int) (Math.random() * 45 + 1);
                String word = rand + "";
                hashSet.add(word);
            }
            if (hashSet.size() == 6) {
                System.out.println(hashSet);
                break;
            }
        }*/

        ArrayList<Integer> myLotto = makeLotto();
        System.out.println(myLotto);

        // 과연 로또를 몇장 구매해야 당첨이 될까?
        // 로또 시뮬레이션
     /*   int[] winLotto = {11, 21, 22, 30, 39, 44};

        int num = 0;
        while(true){
            num++;

            // 로또 한장 구매
            ArrayList<Integer> lotto = makeLotto();

            // winLotto와 lotto 숫자 6개가 일치하는지 확인
            int count = 0;
            for(int i = 0; i < lotto.size(); i++){
                if(winLotto[i] == lotto.get(i)){
                    count++;
                }
            }
            if(count == 6){
                System.out.println("당첨 !!");
                System.out.println(num + "회 구매");
                System.out.println((1000l * num) + "원 구매");
                break;
            }else{
                System.out.println(count + "개 맞춤. 현재 " + num + "회 구매");
            }
        }*/






        System.out.println("\n================================================\n");

        // infoMap의 Key는 사용자의 아이디, Value는 사용자의 비밀번호라고 했을 때 아래와 같이 데이터를 추가해주세요.

        HashMap<String, String> infoMap = new HashMap<>(); // hash 컬렉션 생성

        // 인덱스에 값 넣기
        infoMap.put("a001", "1234a");
        infoMap.put("b001", "1234b");
        infoMap.put("c001", "1234c");
        infoMap.put("d001", "1234d");
        infoMap.put("e001", "1234e");

        Scanner scan = new Scanner(System.in);

        while (true) {

            System.out.println("아이디를 입력해주세요");
            System.out.println(">>> ");
            String inputId = scan.nextLine();

            if (inputId.equals("q") || inputId.equals("exit")) {
                break;
            }

            System.out.println("비밀번호를 입력해주세요");
            System.out.println(">>> ");
            String inputPass = scan.nextLine();

            if (infoMap.containsKey(inputId)) {
                if (infoMap.get(inputId).equals(inputPass)) {
                    System.out.println("로그인 성공");
                    break;
                } else if (!infoMap.get(inputId).equals(inputPass)) {
                    System.out.println("비밀 번호가 틀렸습니다.");
                }
            } else {
                System.out.println("존재하지 않는 아이디입니다.");
            }
        }

     /*   if(infoMap.get(id) != null){
            // 아이디가 존재
            if(infoMap.get(id).equals(pw)){
                // 로그인성공
            }
        }else{
            // 아이디 없음
            System.out.println("존재하지 않는 아이디입니다.");
        }*/


        /*if(infoMap.get(id).equals(pw)){
            // 로그인 성공
        }else{
            // 아이디 혹은 비밀번호가 다릅니다
        }
        */









    } // 메인 끝

    public static ArrayList<Integer> makeLotto(){
        HashSet<Integer> temp = new HashSet<>();
        while(temp.size() < 6){
            temp.add((int)(Math.random()*45)+1);

            // temp의 사이즈가 6이 되었다면 반복종료
            if(temp.size() == 6){
                break;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();

        for(Integer num : temp){ //int가 들어가도 된다. result.addAll(temp)도 가능하다.
            result.add(num);
        }
        Collections.sort(result);

        return result;
    }




}
