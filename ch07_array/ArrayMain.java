package ch07_array;

public class ArrayMain {
    public static void main(String[] args) {
        String samjang = "삼장";
        String woogong = "오공";
        String saojeong = "사오정";
        String palgye = "저팔계";

        // 문자열(String) 값들을 담는 배열 선언
        // 오른쪽 대괄호[] 안 숫자는 (=첨자)
        // 해당 배열이 담을 수 있는 값의 개수를 의미 (배열의 크기)
        String[] seoyugi = new String[4];

        // .length
        // 해당 배열의 크기를 리턴 (문자열의 length와 달리 소괄호가 없음)
        System.out.println(samjang.length());
        System.out.println(seoyugi.length);

        // 배열 안에 담겨있는 값을 요소(element)라고 표현
        // 배열 내 요소를 확인
        // 인덱스 사용 (= 인덱싱)
        System.out.println(seoyugi[0]); // 배열 내 인덱스 0번의 값 확인

        // 크기만 선언되고 값을 별도로 부여하지 않은 배열 내에는
        // 해당 타입의 기본값(default)이 들어있다.
        // 숫자타입: 0, 0.0
        // boolean타입: false
        // 참조타입: null
//        System.out.println(seoyugi[4]); // 배열에 존재하지 않는 인덱스를 넣으면 에러발생

        int [] numbers = new int[5];
        System.out.println(numbers[1]);

        boolean[] booleans = new boolean[3];
        System.out.println(booleans[2]);

        System.out.println("\n=======================================================\n");

        // 배열에 값 넣기
        seoyugi[0] = "삼장";
        seoyugi[1] = "오공";
        seoyugi[2] = "사오정";
        seoyugi[3] = "저팔계";

        System.out.println(seoyugi[2]);

//        seoyugi[4] = "이수근";

        // 이상한 [Ljava.lang.String;@5acf9800 가 출력됨
        System.out.println(seoyugi);

        // 한번에 배열 내 요소들을 확인
        // for문을 이용한 배열 순회
        for (int i = 0; i < seoyugi.length; i++){
            // i 는 0, 1, 2, 3 => seoyugi의 인덱스로 사용 가능
            System.out.println(seoyugi[i]);
        }

        // 배열 내 요소를 한번에 볼 수 있는 함수 만들기
        printArray(seoyugi); // 삼장, 오공, 사오정, 저팔계

        // 자바 에서의 배열은 직접적으로 만들어서 사용하는 경우가 드물다.
        // 배열의 크기가 고정되어 있는게 불편해서
        // (자바에서는 컬렉션을 주로 사용)





    } // main 끝

    public static void printArray(String[] strArray) {
        for (int i = 0; i < strArray.length; i++) {
            // 만약 i가 맨 마지막 인덱스에 해당한다면
            // ,를 같이 출력하지 않는다.
            // i 는 strArray. length 미만인 조건이므로
            // 마지막 반복문의 i는 stringArray.length -1 과 같다.
            if (i == strArray.length - 1) {
                System.out.println(strArray[strArray.length - 1]); // = strArray[i] << 마지막i와 같다
                break;
            }
            System.out.print(strArray[i] + ", ");
        }

    }











}
