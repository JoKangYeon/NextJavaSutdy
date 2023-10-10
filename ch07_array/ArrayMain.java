package ch07_array;

import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.Collections;

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

        // 배열의 장점
        // for문을 이용하여 배열에 담긴 모든 요소들을 한번에 처리할 수 있다.
        // 모든 값 앞에 서유기를 붙여주고자 한다면
        for(int i = 0; i < seoyugi.length; i++){
            seoyugi[i] = "서유기 " + seoyugi[i];
        }
        printArray(seoyugi);

        // 배열 내 특정 요소에 접근하여 처리할 수 있다.
        // 서유기 오공 -> 드래곤볼 오공
        for(int i = 0; i < seoyugi.length; i++){
            // seoyugi[i].equals("서유기 오공")
            if(seoyugi[i].indexOf("오공") != -1){
                // 이때의 seoyugi[i]는 " "서유기 오공"이다.
                seoyugi[i] = seoyugi[i].replace("서유기", "드래곤볼");
            }
        }

        System.out.println("\n=======================================================\n");

        int[] intArray = new int[6];

        // 기존값에 넣는 방식
        intArray[0] = 1;
        intArray[1] = 2;
        intArray[2] = 3;

        // 메소드 오버로딩
        printArray(intArray); // 1, 2, 3, 0, 0, 0

        // 숫자 배열 안에 로또 번호 넣기
        // Math.random() : 0 ~1 사이의 소수 (1은 안나옴)
        // Math.random() * 10 : 0~10 사이의 소수 (10은 안나옴)
        // (int)(Math.random() * 10)  : 0~9 사이의 정수
        // 로또 번호는 1~45 사이의 랜덤 정수
        // (int)(Math.random() * 45) : 0~44 사이의 정수
        // (int)(Math.random() * 45) + 1 : 1~45 사이의 정수
        for(int i = 0; i <intArray.length; i++){
            intArray[i] = (int)(Math.random() * 45) + 1;
        }
        printArray(intArray);

        System.out.println("\n=======================================================\n");

        // 값을 넣으면서 배열을 선언
        String[] students = {"동우", "강연", "유민"};

        // 위와 같음
        String[] stu = new String[3];
        stu[0] = "동우";
        stu[1] = "강연";
        stu[2] = "유민";

        printArray(students);
        printArray(stu);

        System.out.println("\n=======================================================\n");

        // 문자열 나누기
        String myInfo = "정찬웅, 010-7398-7332, akow283@gmail.com";

        // .split(문자열)
        // 괄호안 문자열을 기준으로 해당 문자열을 나누어
        // 문자열 배열로 리턴한다.
        String[] infoArray = myInfo.split(", ");
        System.out.println(infoArray.length);
        System.out.println(infoArray[0]);
        System.out.println(infoArray[1]);
        System.out.println(infoArray[2]);

        //불규칙한 데이터
        myInfo = "정찬웅 , 010-7398-7332,akow283@gmail.com";
        String[]infoArr = myInfo.split(",");
        // 각각의 요소에 좌우 공백 제거
        for(int i = 0; i < infoArr.length; i++){
            infoArr[i] = infoArr[i].trim();
        }
        printArray(infoArr);

        System.out.println("\n=======================================================\n");

        String calStr = "해리포터+반지의제왕+막내아들";
        String[] calArray = calStr.split("\\+");
        // regex란 정규표현식(Regular Expression)의 약자
        // *, ?, + 의 경우 정규표현식에서 특정 기능을 가지는 특수문자이므로
        // System.out.println("\\");
        // 일반 문자로 사용하려면 해당 문자 앞에 \\ 를 붙인다.

        printArray(calArray);

        // 정규표현식 사용 예시
        // PIN 비밀번호를 숫자만 기입했는지 체크
        // PIN 비밀번호에 동일한 숫자가 여러번 들어갔는지 체크
        // 비밀번호에 알파벳 소문자, 대문자, 숫자, 특수기호 각각 1개 이상

        System.out.println("\n=======================================================\n");

        // 배열의 복사
        String[] sinSeoyugi = seoyugi;

        printArray(seoyugi);
        printArray(sinSeoyugi);

        sinSeoyugi[0] = "강호동";
        sinSeoyugi[1] = "이수근";
        printArray(sinSeoyugi);
        printArray(seoyugi);

        // @ 앞은 객체의 타입
        // @ 뒤는 메모리 주소의 해쉬코드를 16진수로 나타낸 것
        // 실제 메모리 주소 103호 -> 해쉬함수 적용 -> 해쉬코드
        System.out.println(seoyugi); // [Ljava.lang.String;@5acf9800
        System.out.println(sinSeoyugi); // [Ljava.lang.String;@5acf9800
        System.out.println(intArray); // [I@279f2327
        System.out.println(Integer.toHexString(1523554304));  // 5acf9800

        // 해쉬코드(hashcode)
        // 객체의 메모리 주소값에 해쉬를 적용한 코드
        System.out.println(seoyugi.hashCode());     // 1523554304
        System.out.println(sinSeoyugi.hashCode());  // 1523554304

        // 해쉬 (hash)
        // 해쉬함수(암호화 알고리즘)를 이용해서
        // 데이터를 암호화하는 기법

        // Base64로 문자열 인코딩 (암호화는 아님)
        Encoder base64Encoder = Base64.getEncoder();
        String password = "1q2w3e4";

        // 문자열을 byet 배열로 변환
        byte[] byteArray = password.getBytes();

        String encryption = new String(base64Encoder.encode(byteArray));
        System.out.println(encryption);

        // 인코딩된 문자열 디코딩
        Decoder base64Decoder = Base64.getDecoder();
        String decryption = new String(base64Decoder.decode(encryption));
        System.out.println(decryption);

        System.out.println("\n=======================================================\n");

        // 올바른 배열 복사
        String[] newSeoyugi = seoyugi.clone();
        printArray(seoyugi);
        printArray(newSeoyugi);

        newSeoyugi[2] = "은지원";

        printArray(seoyugi);
        printArray(newSeoyugi);

        // clone 없이 복제
        String[] synSeoyugi = new String[seoyugi.length];
        for(int i = 0; i <seoyugi.length; i++){
            synSeoyugi[i] = seoyugi[i];
        }

        printArray(seoyugi);
        printArray(synSeoyugi);

        synSeoyugi[2] = "안재현";

        printArray(seoyugi);
        printArray(synSeoyugi);

        System.out.println("\n=======================================================\n");

        // 숫자 배열
        int[] numArray = {6, 13, 22, 3, 7, 30, 40};

        System.out.println(numArray[0]);    // 6
        System.out.println(numArray[1]);    // 13

        // 인덱스 0번 값과 인덱스 1번 값 위치를 바꿔보기
        int temp = numArray[0];
        numArray[0] = numArray[1];
        numArray[1] = temp;



        System.out.println(numArray[0]);    // 13
        System.out.println(numArray[1]);    // 6

        printArray(numArray);
        swap(numArray[3], numArray[4]);
        printArray(numArray);

        // 가끔 면접에서 묻는 문제
        // Call by Value 와 Call by reference 구분
        // 기본타입 변수에 대해서는 Call by Value로 동작
        // 참조타입 변수에 대해서는 Call by Reference로 동작
        int a = 10;
        int b = a;

        System.out.println(b);

        a= 20;
        System.out.println(b);

        swap(a, b); // 1: 20, b:10

        System.out.println(a);    // 20
        System.out.println(b);    // 10

        printArray(numArray);
        swap(numArray, 3, 4);
        printArray(numArray);

        System.out.println("\n=======================================================\n");

        // 정렬 (sort)
        Arrays.sort(numArray); // 오름차순
        printArray(numArray);

        // 내림차순 정렬
        // 이 방법은 참조타입 객체를 담는 배열에 대해서만 가능한 방법
//        Arrays.sort(numArray, Collections.reverseOrder());

        // 오름차순을 이용한 내림차순
        // 1. numArray의 모든 요소에 -1을 곱함 (2, 40) -> (-2, -40)
        // 2. Arrays.sort(numArray) 적용 (-2, -40) -> (-40, -2)
        // 3. numArray의 모든 요소에 -1을 곱함 (-40, -2) -> (40, 2)
        for(int i =0; i < numArray.length; i++){
            numArray[i] *= -1;
        }
        printArray(numArray);

        Arrays.sort(numArray);
        printArray(numArray);

        for(int i =0; i < numArray.length; i++){
            numArray[i] *= -1;
        }

        printArray(numArray);


        // 버블정렬 (알고리즘)
        int[] intArr = {3, 5, 8, 2, 4, 1};

        for(int i = 0; i < intArr.length - 1; i++){
            // 왼쪽이 오른쪽보다 큰지 비교
            if(intArr[i] > intArr[i+1]){
                // 자리바꾼다,
                int tmp = intArr[i];
                intArr[i] = intArr[i+1];
                intArr[i+1] = tmp;
            }
        }
        printArray(intArr);

        for(int i = 0; i < intArr.length - 1; i++){
            // 왼쪽이 오른쪽보다 큰지 비교
            if(intArr[i] > intArr[i+1]){
                // 자리바꾼다,
                int tmp = intArr[i];
                intArr[i] = intArr[i+1];
                intArr[i+1] = tmp;
            }
        }
        printArray(intArr);

        for(int k = 0; k < intArray.length - 1; k++){
            for(int i = 0; i < intArr.length - 1; i++){
                // 왼쪽이 오른쪽보다 큰지 비교 >
                // 왼쪽이 오른쪽보다 작은지 비교 <
                if(intArr[i] > intArr[i+1]){
                    // 자리바꾼다,
                    int tmp = intArr[i];
                    intArr[i] = intArr[i+1];
                    intArr[i+1] = tmp;
                }
            }
        }
        printArray(intArr); // 오름차순 정렬

        System.out.println("\n======================================================\n");

        // 다차원 배열
        // 일차원 배열
        int[] oneDirArr = {1, 2, 3};
        // 이차원 배열
        int[][] twoDirArr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        // 1 2 3
        // 4 5 6
        // 7 8 9

        // 2행 {4, 5, 6} 꺼내기
        printArray(twoDirArr[1]);

        // 3행 2열 {8}
        System.out.println(twoDirArr[2][1]);

        // 3차원 배열
        int [][][] threeDirArr = {{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                                  {{10, 11, 12}, {13, 14, 15}, {16, 17, 18}},
                                  {{19, 20, 21}, {22, 23, 24}, {25, 26, 27}}};

        // 0층
        // 1 2 3
        // 4 5 6
        // 7 8  9
        // 1층
        // 10 11 12
        // 13 14 15
        // 16 17 18

        System.out.println(threeDirArr[1][0][0]);

        // 로또방 가서 자동 5천원 구매
        // 로또 5줄짜리 나옴
        // 2차원 배열 이용






    } // main 끝

    public static void swap(int idxA, int idxB){
        int temp = idxA;
        idxA = idxB;
        idxB = temp;
    }

    public static void swap(int[] intArray, int idxA, int idxB){
        int temp = intArray[idxA];
        intArray[idxA] = intArray[idxB];
        intArray[idxB] = temp;
    }




    public  static void printArray(int[] intArray){
        for (int i = 0; i < intArray.length; i++) {
            if (i == intArray.length - 1) {
                System.out.println(intArray[intArray.length - 1]); // = strArray[i] << 마지막i와 같다
                break;
            }
            System.out.print(intArray[i] + ", ");
        }
    }

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
