package ch09_class.member;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberMain {

    public static void main(String[] args) {
        // 회원가입/회원목록/로그인
        // 회원: id, pw, name
        // 회원관리 객체: ArrayList<Member> memList

        MemberDB memDB = new MemberDB();

        System.out.println(memDB.getMemList());
        ArrayList<Member> memList = memDB.getMemList();

        Scanner scan = new Scanner(System.in);

        while(true){
            System.out.println("행동을 선택해주세요");
            System.out.println("1. 회원가입 | 2. 로그인 | 3, 회원목록 | 4. 종료");
            System.out.print(">>> ");

            int command = Integer.parseInt(scan.nextLine());

            if(command == 1){
                // TODO 회원가입
                System.out.println("아이디 입력: ");
                String inputId = scan.nextLine();

                System.out.println("비밀번호 입력: ");
                String inputPw = scan.nextLine();

                System.out.println("이름 입력: ");
                String inputName = scan.nextLine();

                // 입력받은 내용을 토대로 새로운 Member 객체 생성 후
                // memDB 내 memList에 추가해주기
                Member mem = new Member(inputId, inputPw, inputName);
                memList.add(mem);

            }else if(command == 2){
                // TODO 로그인
                System.out.println("아이디 입력: ");
                String inputId = scan.nextLine();

                System.out.println("비밀번호 입력: ");
                String inputPw = scan.nextLine();

                // memDB 내 memList에 입력한 아이디와 비밀번호가 일치하는
                // Member 객체가 존재하는지 체크
                // 존재하면 "로그인 성공, (이름)님 환영합니다!!"
                // 존재하지 않으면 "아이디 혹은 비밀번호를 잘못 입력하셨습니다."
                for(int i = 0; i < memList.size(); i++){
                    Member temp = memList.get(i);
                    if((temp.getId()).equals(inputId) && temp.getPw().equals(inputPw)){
                      // 로그인 성공
                        System.out.println("로그인 성공!! " + temp.getName() + "님 환영합니다.");
                        break;
                    }else if(!(temp.getId()).equals(inputId) && temp.getPw().equals(inputPw)){
                        System.out.println("아이디 혹은 비밀번호를 잘못입력하셨습니다.");
                    }
                }

            }else if(command == 3) {
                // TODO 회원목록
                // memDB 내 memList 내부 요소 확인
                for(int i = 0; i < memList.size(); i++){
                    System.out.println(memList.get(i));
                }
            }else{
                // 종료
                System.out.println("종료하였습니다.");
                break;
            }
        }






    }
}
