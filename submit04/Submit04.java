package submit04;

import java.util.Scanner;
public class Submit04 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // 층을 입력받기

        // 입력받은 층에 대한 엘리베이터 A와의 위치 차이 구하기
        // 입력받은 층에 대한 엘리베이터 B와의 위치 차이 구하기

        // A 위치차이와 B 위치차이의 크기를 비교해서
        // 크기가 더 작은 엘리베이터를 이동한다




      /*  int elevatorA = 10;
        int elevatorB = 4;

        while (true) {
            System.out.println("===========화영빌딩 엘리베이터=============");
            System.out.println("승강기 A의 현재위치: " + elevatorA + "층");
            System.out.println("승강기 B의 현재위치: " + elevatorB + "층");
            System.out.println("몇층에 계시나요? [종료하시려면 q 또는 exit 입력]");
            System.out.println(">>> ");
            int command = Integer.parseInt(scan.nextLine());
            if(command < 11){

                if (Math.abs(elevatorA - command) < Math.abs(elevatorB - command)) {
                    System.out.println(command + "층에서 엘리베이터를 호출합니다.");
                    System.out.println("승강기 A가 " + command + "층으로 이동하였습니다");
                }else if (Math.abs(elevatorA - command) > Math.abs(elevatorB - command)) {
                    System.out.println(command + "층에서 엘리베이터를 호출합니다.");
                    System.out.println("승강기 B가 " + command + "층으로 이동하였습니다");
                }else if(Math.abs(elevatorA - command) == Math.abs(elevatorB - command) && elevatorA > elevatorB) {
                    System.out.println(command + "층에서 엘리베이터를 호출합니다.");
                    System.out.println("승강기 A가 " + command + "층으로 이동하였습니다");
                }else if(Math.abs(elevatorA - command) == Math.abs(elevatorB - command) && elevatorA < elevatorB) {
                    System.out.println(command + "층에서 엘리베이터를 호출합니다.");
                    System.out.println("승강기 B가 " + command + "층으로 이동하였습니다");
                }
            }else if(scan.nextLine().equals("q") || scan.nextLine().equals("exit")){
                System.out.println("프로그램이 종료되었습니다.");
                break;
            }

        }
*/


        int elevatorA = 10;
        int elevatorB = 4;

        while (true) {
            System.out.println("===========화영빌딩 엘리베이터=============");
            System.out.println("승강기 A의 현재위치: " + elevatorA + "층");
            System.out.println("승강기 B의 현재위치: " + elevatorB + "층");
            System.out.println("몇층에 계시나요? [종료하시려면 q 또는 exit 입력]");
            System.out.println(">>> ");

            // 층 입력받기
            String inputText = scan.nextLine();

            if(inputText.equals("q") || inputText.equals("exit")){
                break;
            }

            // inputText가 4인 경우
            int command = Integer.parseInt(scan.nextLine()); // "4"

            // 입력받은 층에 대한 엘리베이터 A와의 위치 차이 구하기
            int diffA = Math.abs(elevatorA - command);

            // 입력받은 층에 대한 엘리베이터 B와의 위치 차이 구하기
            int diffB = Math.abs(elevatorB - command);

            // A 위치차이와 B 위치차이의 크기를 비교해서

            // 크기가 더 작은 엘리베이터를 이동시킨다.

            if(diffA < diffB){
                System.out.println("승강기 A가 " + command + "층으로 이동하였습니다");
                elevatorA = command;
            }else if(diffA > diffB){
                System.out.println("승강기 B가 " + command + "층으로 이동하였습니다");
                elevatorB = command;
            }else {
                // 층수 차이가 같으면 위층에 있는 엘리베이터가 이동
                if(elevatorA > elevatorB){
                    System.out.println("승강기 A가 " + command + "층으로 이동하였습니다");
                }else if(elevatorA < elevatorB){
                    System.out.println("승강기 B가 " + command + "층으로 이동하였습니다");
                }
            }






        }















    }
}
