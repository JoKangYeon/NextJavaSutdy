package kangyeon.submit02;

import java.util.Scanner;

public class Submit02 {

    public static void main(String[] args) {

  /*      Scanner scan = new Scanner(System.in);

        System.out.println("이름을 입력해주세요.");
        System.out.print(">>> ");
        String name = scan.nextLine();

        System.out.println("국어 점수롤 입력해주세요.");
        System.out.print(">>> ");
        String hanScore = scan.nextLine();
        int hScore = Integer.parseInt(hanScore);

        System.out.println("영어 점수롤 입력해주세요.");
        System.out.print(">>> ");
        String engScore = scan.nextLine();
        int eScore = Integer.parseInt(engScore);

        System.out.println("수학 점수롤 입력해주세요.");
        System.out.print(">>> ");
        String mathScore = scan.nextLine();
        int mScore = Integer.parseInt(mathScore);

        double averScore = ((double)hScore + eScore + mScore) / 3;
        //double averScore = (hScore + eScore + mScore) / 3.0;

        System.out.println("이름: " + name);
        System.out.println("국어: " + hanScore);
        System.out.println("영어: " + engScore);
        System.out.println("수학: " + mathScore);
        System.out.printf("평균: " + "%.2f\n", averScore);*/

        System.out.println("\n=====================\n");

        int example = 278;
        // 자동 형변환을 이용한 int -> String 변환
        String zzExample = example + "";
        int aaExample = Integer.parseInt(zzExample.substring(0, 1));
        int bbExample = Integer.parseInt(zzExample.substring(1, 2));
        int ccExample = Integer.parseInt(zzExample.substring(2, 3));
        System.out.println("결과는 : " + (aaExample + bbExample + ccExample));



















    }



}
