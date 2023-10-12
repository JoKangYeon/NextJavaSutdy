package kangyeon.submit.submit08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Submit08 {

    public static void main(String[] args) {

        ArrayList<Integer> intSet = new ArrayList<>();
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
        }

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


    }
}
