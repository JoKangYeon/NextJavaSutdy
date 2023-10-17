package kangyeon.submit.submit10;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryMain {

    public static void main(String[] args) {

        String strBooks = "삼국지, 해리포터와 마법사의 돌, 해리포터와 비밀의 방 , 해리포터와 아즈카반의 죄수,해리포터와 불사조 기사단, 해리포터와 혼혈왕자," +
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

        while(true){

            System.out.println("행동을 선택해주세요.");
            System.out.println("1. 책 입고 | 2. 책 대여 | 3. 책 목록 | 4. 책 검색 | 5. 종료");
            System.out.print(">>> ");

            int command = Integer.parseInt(scan.nextLine());

            if(command == 1){
                // 책 입고
                System.out.println("도서 번호를 입력해주세요.");
                System.out.print(">>> ");
                int inputNo = Integer.parseInt(scan.nextLine());
                bookList.inBook(inputNo);
                System.out.println(bookList.getBookList().get(inputNo - 1).getTitle() + " 이(가) 입고되었습니다.");
            }else if(command == 2){
                // 책 대여
                System.out.println("도서 번호를 입력해주세요.");
                System.out.print(">>> ");
                int inputNum = Integer.parseInt(scan.nextLine());
                bookList.outBook(inputNum);
                System.out.println(bookList.getBookList().get(inputNum - 1).getTitle() + " 을 대여하셨습니다.");
            }else if(command == 3){
                // 책 목록
                bookList.checkBook();

            }else if(command == 4){
                // 책 검색
                System.out.println("도서 이름을 입력해주세요.");
                System.out.print(">>> ");
                String inputTitle = scan.nextLine();
                int count = 0;
                for(int i = 0; i < bookList.getBookList().size(); i++){
                    if(bookList.getBookList().get(i).getTitle().contains(inputTitle)){
                        count++;
                    }
                }
                if(count == 1){
                    for(int i = 0; i < bookList.getBookList().size(); i++){
                        if(bookList.getBookList().get(i).getTitle().contains(inputTitle)){
                            bookList.getBookList().get(i).setFalse(true);
                            System.out.println(bookList.getBookList().get(i).getTitle() + "을 대여하셨습니다.");
                        }
                    }
                }else if(count >= 1){
                    for(int i = 0; i < bookList.getBookList().size(); i++){
                        if(bookList.getBookList().get(i).getTitle().contains(inputTitle)){
                            System.out.println(bookList.getBookList().get(i));
                        }
                    }
                    System.out.println("도서 번호를 입력해주세요.");
                    System.out.print(">>> ");
                    int inputNum = Integer.parseInt(scan.nextLine());
                    bookList.getBookList().get(inputNum - 1).setFalse(true);
                    System.out.println(bookList.getBookList().get(inputNum - 1).getTitle() + "을 대여하셨습니다.");
                }

            }else if(command == 5){
                // 종료
                System.out.println("잠시 후 종료됩니다.");
                break;
            }

        }





    }
}
