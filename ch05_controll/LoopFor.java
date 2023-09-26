package ch05_controll;

public class LoopFor {

    public static void main(String[] args) {

        // 반복문
        // for문

        // 콘솔창에 1부터 10까지 출력
        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
        System.out.println(4);
        System.out.println(5);
        System.out.println(6);
        System.out.println(7);
        System.out.println(8);
        System.out.println(9);
        System.out.println(10);

        int one = 1;
        System.out.println(one++);
        System.out.println(one++);
        System.out.println(one++);
        System.out.println(one++);
        System.out.println(one++);
        System.out.println(one++);
        System.out.println(one++);
        System.out.println(one++);
        System.out.println(one++);
        System.out.println(one++);

        // 반복문 사용
        // ; 를 기준으로
        // (초기화식 ; 조건식 ; 증감식)
        // 초기화식에는 for문의 반복횟수를 결정해주는 변수 선언
        // 증감식에는 for문이 반복될때마다 변수의 증가량 지정
        // 조건식에는 for문이 반복되는 기준을 정한다
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        // for문 내부 변수 i는 for문 내에서 선언되고, for문 종료시 제거된다.
        // = 변수의 스코프
//        System.out.println(i);
        for (int i = 1; i < 11; i++) {
            System.out.println(i);
        }

        // for문 내부 변수 i는 for문의 반복횟수를 조정하기 위함이
        // 주 목적이므로 꼭 i를 for문 내에서 쓸 필요는 없다.
        // i는 단순 변수명일뿐이므로, i가 아닌 다른 단어를 사용해도 된다
        one = 1;
        // 10번 반복하는 for문
        for (int number = 0; number < 10; number += 1) {
            System.out.println(one++);
        }

        // 정말 많이 쓰게될 for문 형식
        // 20번 반복하는 for문
        for (int i = 0; i < 20; i++) {

        }

        System.out.println("\n=================================================\n");

        // 1부터 20까지 더한 값?
        // 변수의 스코프를 이용한 for문
        int sum = 0;
        for (int i = 1; i <= 20; i++) {
            sum += i;
        }
        System.out.println(sum);

        // 자동 줄맞춤 [Ctrl + alt + l]

        // 1부터 40까지 중에 짝수끼리만 더한 값?


        sum = 0;
        for (int i = 1; i <= 40; i++) {
            // 짝수일때만(조건) sum에 i를 더한다
            sum += i;
            if (i % 2 == 0) {
                sum += i;
            }
        }


        sum = 0;
        for (int i = 0; i <= 40; i += 2) {
            // i = 0, i = 2, i = 4
            sum += i;
        }
        System.out.println(sum);


        // 0부터 2까지 0.2마다 출력
        // 소수인 double, float 타입의 연산은 정확하지 않으므로 비추천한다.
        for (double i = 0; i <= 2; i += 0.2) {
            System.out.println(i);
        }

        // 0부터 2까지 0.2마다 출력
        for (int i = 0; i <= 20; i += 2) { // 0, 2, 4, 6, 8... 20
            System.out.println((double) i / 10); // 0, 0.2, 0.4 ... 2
        }

        System.out.println("\n=================================================\n");

        // 구구단 2단
        // 2 * 1 = 2
        // 2 * 2 = 4
        // 2 * 3 = 6
        // 2 * 4 = 8
        // 2 * 9 = 18
        for (int i = 1; i <= 9; i++) {
            System.out.println("2 * " + i + " = " + (i * 2));
        }

        System.out.println("\n=================================================\n");

        System.out.println("*");
        System.out.println("**");
        System.out.println("***");
        System.out.println("****");
        System.out.println("*****");

        // 위의 코드를 for문을 이용하여 같은 결과가 나오도록 만들기

        String star = "";
        for (int i = 1; i <= 5; i++) {
            star += "*";
            System.out.println(star);
        }


        System.out.println("\n=================================================\n");

        // 나머지 연산자(%)  의 사용 예시
        // for문 내에서 순환하는  숫자에 대해 사용하면 좋다.

        // 국수공장에서 면을 20cm 뽑고있다.
        for (int i = 0; i < 20; i++) {
            System.out.println("||||||||");

            // i가 4, 9 14, ... 일때 절단 시키기
            if (i == 4 || i == 9 || i == 14) {
                System.out.println("--------");
            }

            // 4, 9, 14, 19 24, ...는
            // 전부 5로 나누었을때의 나머지가 4인 숫자들
            if (i % 5 == 4) {
                System.out.println("--------");
            }
        }

        System.out.println("\n=================================================\n");

        // 라면 공장에서 면을 30cm 뽑고있는데
        // 6cm 마다 잘라 주어야 한다.
        // ////////
        // \\\\\\\\
        // ////////
        // \\\\\\\\

        for (int i = 0; i < 30; i++) {

           /* if(i % 6 == 5){
                System.out.println("--------");*/
            if (i % 2 == 0) {
                System.out.println("////////");
            } else {
                System.out.println("\\\\\\\\\\\\\\\\");
            }

            // i가 5, 11, 17, 23, /// 일때 자른다.
            // 6으로 나누었을때, 나머지가 5인 숫자 (조건 체크)
            // 조건을 체크하는 목적이 다른 if문은 서로 분리해야 한다.
            if (i % 6 == 5) {
                System.out.println("--------");
            }
        }
        // 10부터 1까지 출력
        int num = 10;
        for (int i = 0; i < 10; i++){
            System.out.println(num--);
        }

        // 거꾸로 for문
        for(int i = 10; i >= 1; i--){
            System.out.println(i);
        }


        System.out.println("\n=================================================\n");

        // for문으로 String을 가지고 놀기

        // 숫자형 문자열의 각 자리수를 더한 결과 얻기
        // submit02에서 했던걸 for문을 이용해서 해결
        String example = "893798333";
        int a = 0;
        for(int i = 0; i < example.length(); i++){

            System.out.println((Integer.parseInt(example.substring(i, i + 1))));
            a += Integer.parseInt(example.substring(i, i + 1));
        }
        System.out.println(a);

        System.out.println("\n=================================================\n");
        String syusyu = "슛슈슈ㅠ슈슛슈슈슈슈슈슈슈슈슈슈슈슈슈";

        // syusyu 에서 "슈"가 몇글자 들어가있는지 세어보기
        String syu = "";
        int count = 0;
        for(int i = 0; i < syusyu.length(); i++){
            syu = syusyu.substring(i, i + 1);
            System.out.println(syu);
            if(syu.equals("슈")){
                System.out.println(syu);
                count += 1;
            }
        }
        System.out.println(count);




















    }
}
