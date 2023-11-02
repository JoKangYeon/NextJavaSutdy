package ch14_jdbc_jsp.main;

import ch14_jdbc_jsp.dao.MemberDAO;
import ch14_jdbc_jsp.dto.MemberDTO;
import ch14_jdbc_jsp.jdbc.ConnectionFactory;
import ch14_jdbc_jsp.jdbc.ConnectionPool;
import ch14_jdbc_jsp.service.MemberService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class JdbcMain {

    public static void main(String[] args) {

        MemberService memberService = MemberService.getInstance();

        Scanner scan = new Scanner(System.in);

        while(true){
            System.out.println("행동을 선택해주세요.");
            System.out.println("1. 회원가입 | 2. 로그인 | 3. 회원목록 | 4. 종료");
            System.out.print(">>> ");
            int command = Integer.parseInt(scan.nextLine());

            if (command == 1){
                // 회원가입
                System.out.println("아이디 입력: ");
                String id = scan.nextLine();

                System.out.println("비밀번호 입력: ");
                String pw = scan.nextLine();

                System.out.println("이름 입력: ");
                String name = scan.nextLine();

                // 점수는 0이 기본값
                MemberDTO member = new MemberDTO(id, pw, name,0);
                memberService.signUp(member);

            }else if(command == 2){
                // 로그인
                System.out.println("아이디 입력: ");
                String id = scan.nextLine();

                System.out.println("비밀번호 입력: ");
                String pw = scan.nextLine();

                MemberDTO member = new MemberDTO(id, pw, "",0);

                // 유효한 id와 pw 입력시 login 객체 내부 필드변수들은 채워져있음
                // 아이디나 비밀번호가 틀리면 객체 내부 필드변수들이 비어있음
                MemberDTO login = memberService.login(member);

                if(login.getMemId() != null){
                    System.out.println("로그인 성공" + login.getMemName() + "님 환영합니다.");
                }else{
                    System.out.println("아이디 혹은 비밀번호가 틀립니다.");
                }

            }else if(command == 3){
                // 회원목록
                ArrayList<MemberDTO> memList = memberService.getMemberList();

                for(int i = 0; i < memList.size(); i++){
                    System.out.println(memList.get(i));
                }

            }else if(command == 4){
                // 종료
                break;
            }else{
                System.out.println("잘못 입력하셨습니다.");
            }





















        }






































































        /* ArrayList<MemberDTO> memberList = memberService.getMemberList();

        for(int i = 0; i < memberList.size(); i++){
            System.out.println(memberList.get(i).getMemName());
        }*/


/*
        ConnectionPool cp = ConnectionPool.getInstance();

        Connection conn = cp.getConnection();

        MemberDAO dao = MemberDAO.getInstance();

        try {
            ArrayList<MemberDTO> memList = dao.getMemberList(conn);
            cp.releaseConnection(conn);

            for(int i = 0; i < memList.size(); i++){
                System.out.println(memList.get(i).getMemName());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
*/


    }
}
