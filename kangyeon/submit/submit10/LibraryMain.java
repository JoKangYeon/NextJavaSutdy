package kangyeon.submit.submit10;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryMain {

    public static void main(String[] args) {

     /*   String strBooks = "삼국지, 해리포터와 마법사의 돌, 해리포터와 비밀의 방 , 해리포터와 아즈카반의 죄수,해리포터와 불사조 기사단, 해리포터와 혼혈왕자," +
                " 해리포터와 죽음의 성물,어린왕자, 나의 라임 오렌지나무, 이것이 자바다, " +
                "좋은생각, 반지의 제왕: 반지 원정대, 반지의 제왕: 두 개의 탑, 반지의 제왕: 왕의 귀환, 토익보카, 개미";

        // split 문자열 쪼개기
        String[] infoBook = strBooks.split(",");

        // 공백제거
        for(int i =0; i < infoBook.length; i++){
            infoBook[i] = infoBook[i].trim();
        }
        // 데이터 확인
//        System.out.println(infoBook[1]);

        // 라이브러리 객체 선언
        Library bookList = Library.getInstance();

        // Book객체를 bookList에 담기
        for(int i = 0; i < infoBook.length; i++){
            bookList.getBookList().add(new Book(bookList.getBookList().size() + 1, infoBook[i]));
        }

        // 담은 데이터 확인
//        for(int i = 0; i < bookList.getBookList().size(); i++) {
//            System.out.println(bookList.getBookList().get(i));
//        }

        // 스캐너 객체 소환
        Scanner scan = new Scanner(System.in);
        // 대여 행동을 위한 변수 선언
        int count = 0;

        while (true) {
            System.out.println("행동을 선택해주세요.");
            System.out.println("1. 책 입고 | 2. 책 대여 | 3. 책 목록 | 4. 책 검색 | 5. 종료");
            System.out.print(">>> ");

            int command = Integer.parseInt(scan.nextLine());

            if (command == 1) {
                // 책 입고
                System.out.println("도서 번호를 입력해주세요.");
                System.out.print(">>> ");
                int inputNo = Integer.parseInt(scan.nextLine());
                if(bookList.getBookList().size() < inputNo){
                    System.out.println("존재하지 않는 번호입니다.");
                    continue;
                }
                bookList.inBook(inputNo);
            } else if (command == 2) {
                // 책 대여
                if (count == 0) {
                    System.out.println("도서 번호를 입력해주세요.");
                    System.out.print(">>> ");
                    int inputNum = Integer.parseInt(scan.nextLine());
                    if(bookList.getBookList().size() < inputNum){
                        System.out.println("존재하지 않는 번호입니다.");
                        continue;
                    }
                    bookList.outBook(inputNum);
                } else if (count == 1) {
                    count--;
                    System.out.println("도서 제목을 입력해주세요.");
                    System.out.print(">>> ");
                    String inputTitle = scan.nextLine();
                    bookList.searchOneBook(inputTitle);
                } else if (count > 1) {
                    count = 0;
                    System.out.println("도서 제목을 입력해주세요.");
                    System.out.print(">>> ");
                    String inputTitle = scan.nextLine();
                    bookList.searchBook(inputTitle);

                    System.out.println("도서 번호를 입력해주세요.");
                    System.out.print(">>> ");
                    int inputNum = Integer.parseInt(scan.nextLine());
                    // 해리포터가 아닌 다른도서 번호를 입력했을 때.......
                    bookList.outBook(inputNum);
                }
            } else if (command == 3) {
                // 책 목록
                bookList.checkBook();

            } else if (command == 4) {
                // 책 검색
                System.out.println("도서 제목을 입력해주세요.");
                System.out.print(">>> ");
                String inputTitle = scan.nextLine();
                for (int i = 0; i < bookList.getBookList().size(); i++) {
                    if (bookList.getBookList().get(i).getTitle().contains(inputTitle)) {
                        System.out.println(bookList.getBookList().get(i));
                        count++;
                    }
                }


            } else if (command == 5) {
                // 종료
                System.out.println("잠시 후 종료됩니다.");
                break;
            }

        }*/

        Library lib =Library.getInstance();

        Scanner scan = new Scanner(System.in);

        while (true){
            System.out.println("행동을 선택해주세요.");
            System.out.println("1. 책 입고 | 2. 책 대여 | 3. 책 목록 | 4. 책 검색 | 5. 종료");
            System.out.print(">>> ");

            int command = Integer.parseInt(scan.nextLine());

            if(command == 1){
                // 책 입고
                System.out.println("도서 번호를 입력해주세요.");
                System.out.print(">>> ");
                int no = Integer.parseInt(scan.nextLine());
                lib.back(no);

            }else if (command == 2){
                // 책 대여
                System.out.println("도서 번호를 입력해주세요.");
                System.out.print(">>> ");
                int no = Integer.parseInt(scan.nextLine());
                lib.borrow(no);


            }else if(command == 3){
                // 책 목록
                lib.printBook();

            }else if(command == 4){
                // 책 검색
                System.out.println("도서 제목을 입력해주세요.");
                System.out.print(">>> ");

                String keyword = scan.nextLine();

                lib.searchBook(keyword);

            }else{
                // 종료
                System.out.println("종료되었습니다.");
                break;
            }



        }












    }
}
