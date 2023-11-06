package ch14_jdbc_jsp.main;

import ch14_jdbc_jsp.dao.MemberDAO;
import ch14_jdbc_jsp.dto.BoardDTO;
import ch14_jdbc_jsp.dto.MemberDTO;
import ch14_jdbc_jsp.jdbc.ConnectionFactory;
import ch14_jdbc_jsp.jdbc.ConnectionPool;
import ch14_jdbc_jsp.service.BoardService;
import ch14_jdbc_jsp.service.MemberService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class JdbcMain {
    public static void main(String[] args) {
        MemberService memberService = MemberService.getInstance();
        BoardService boardService = BoardService.getInstance();

        Scanner scan = new Scanner(System.in);

        while(true){
            System.out.println("행동을 선택해주세요.");
            System.out.println("1. 회원가입 | 2. 로그인 | 3. 회원목록 | 4. 종료");
            System.out.print(">>> ");

            int command = Integer.parseInt(scan.nextLine());

            if(command == 1){
                // 회원가입
                System.out.print("아이디 입력: ");
                String id = scan.nextLine();

                System.out.print("비밀번호 입력: ");
                String pw = scan.nextLine();

                System.out.print("이름 입력: ");
                String name = scan.nextLine();

                // 점수는 0이 기본값
                MemberDTO member = new MemberDTO(id, pw, name, 0);
                memberService.signUp(member);

            }else if(command == 2){
                // 로그인
                System.out.print("아이디 입력: ");
                String id = scan.nextLine();

                System.out.print("비밀번호 입력: ");
                String pw = scan.nextLine();

                MemberDTO member = new MemberDTO(id, pw, "", 0);

                // 유효한 id와 pw 입력시 login 객체 내부 필드변수들은 채워져있음
                // 아이디나 비밀번호가 틀리면 객체 내부 필드변수들이 비어있음
                MemberDTO login = memberService.login(member);

                if(login.getMemId() != null){
                    System.out.println("로그인 성공!! " + login.getMemName() + "님 환영합니다.");

                    // 게시판 진입
                    while(true){
                        // 게시글 목록 출력
                        ArrayList<BoardDTO> boardList = boardService.getBoardList();
                        for(int i = 0; i < boardList.size(); i++){
                            BoardDTO bo = boardList.get(i);
                            System.out.println("[ " + bo.getBoNo() + " | " + bo.getBoTitle() + " | "
                                    + bo.getMemName() + " | " + bo.getBoDate() + " ]");
                        }

                        System.out.println("행동을 선택해주세요.");
                        System.out.println("1. 글쓰기 | 2. 글상세보기 | 3. 글삭제 | 4. 로그아웃");
                        System.out.print(">>> ");

                        int select = Integer.parseInt(scan.nextLine());

                        if(select == 1){
                            // 글쓰기
                            System.out.print("글 제목 :");
                            String title = scan.nextLine();

                            System.out.println("글 내용");
                            System.out.print(": ");
                            String content = scan.nextLine();

                            // 입력받은 title과 content를 가지고
                            // DB에 boards 테이블에 INSERT
                            // (board 객체 내부에는 title, content, id 가 들어가 있어야 한다)
                            BoardDTO board = new BoardDTO();
                            board.setBoTitle(title);
                            board.setBoContent(content);
                            board.setBoId(login.getMemId());  // 현재 로그인한 사람의 id

                            boardService.writeBoard(board);
                        }else if(select == 2){
                            // 글 상세보기
                            System.out.print("글 번호 입력: ");
                            int no = Integer.parseInt(scan.nextLine());

                            // 글번호를 이용하여 해당 게시글을 DB로부터 가져와서
                            // 제목
                            // 작성자         작성일
                            // 내용
                            // 위와 같은 형태로 콘솔창에 출력
                            BoardDTO board = boardService.getBoard(no);

                            if(board.getBoTitle() != null){
                                System.out.println("=========================");
                                System.out.println("제목: " + board.getBoTitle());
                                System.out.println(board.getMemName() + "\t\t\t" + board.getBoDate());
                                System.out.println("-------------------------");
                                System.out.println(board.getBoContent());
                                System.out.println("=========================");
                            }else{
                                System.out.println("유효하지 않은 게시글 번호입니다.");
                            }

                        }else if(select == 3){
                            // 글 삭제
                            System.out.print("글 번호 입력: ");
                            int no = Integer.parseInt(scan.nextLine());

                            boardService.deleteBoard(no, login.getMemId());

                            // 해당 글 번호인 게시글의 del_yn = 'Y' 로 UPDATE 해주기


                            // @ 글 삭제시 해당 게시글이 현재 로그인한 사람이 작성한
                            // 게시글이어야만 삭제 가능


                        }else if(select == 4){
                            // 로그아웃
                            System.out.println("로그아웃 하였습니다.");
                            break;
                        }
                    }

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



    }
}