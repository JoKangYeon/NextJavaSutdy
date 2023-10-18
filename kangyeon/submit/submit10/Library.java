package kangyeon.submit.submit10;

import java.util.ArrayList;

public class Library {

  /*  private ArrayList<Book> bookList = new ArrayList<>();

    private Library() {
    }

    private  static Library instance = new Library();

    public static Library getInstance() { return instance; }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    // 도서 입고 메소드 만들기
    public void inBook(int a){
        Book temp = instance.getBookList().get(a - 1);
        if(temp.isFalse() == true){
            temp.setFalse(false);
            System.out.println(instance.getBookList().get(a - 1).getTitle() + "이(가) 입고되었습니다.");
        }
        return;
    }

    // 도서 대여 메소드 만들기
    public void outBook(int a){
        Book temp = instance.getBookList().get(a - 1);
        if(temp.isFalse() == false){
            temp.setFalse(true);
            System.out.println(instance.getBookList().get(a - 1).getTitle() + "을 대여하셨습니다.");
        }
        return;
    }

    // 도서 목록 확인 메소드 만들기
    public void checkBook(){
        for (int i = 0; i < instance.getBookList().size(); i++) {
            System.out.println(instance.getBookList().get(i));
        }
    }

    // 도서 목록 검색 (1권) 메소드 만들기
    public void searchOneBook(String a){
        for(int i = 0; i < instance.getBookList().size(); i++){
            Book temp = instance.getBookList().get(i);
            if(temp.getTitle().contains(a)){
                temp.setFalse(true);
                System.out.println(temp.getTitle() + "을 대여하셨습니다.");
            }
        }
    }

    // 도서 목록 검색 (여러권) 메소드 만들기
    public void searchBook(String a){
        for(int i = 0; i < instance.getBookList().size(); i++){
            if(instance.getBookList().get(i).getTitle().contains(a)){
                System.out.println(instance.getBookList().get(i));
            }
        }
    }*/

    private ArrayList<Book> bookList = new ArrayList<>();

    private Library(){
        String strBooks = "삼국지, 해리포터와 마법사의 돌, 해리포터와 비밀의 방 , 해리포터와 아즈카반의 죄수,해리포터와 불사조 기사단, 해리포터와 혼혈왕자," +
                " 해리포터와 죽음의 성물,어린왕자, 나의 라임 오렌지나무, 이것이 자바다, " +
                "좋은생각, 반지의 제왕: 반지 원정대, 반지의 제왕: 두 개의 탑, 반지의 제왕: 왕의 귀환, 토익보카, 개미";

        String[] strArray = strBooks.split(",");
        for(int i = 0; i < strArray.length; i++){
            strArray[i]= strArray[i].trim();
            System.out.println(strArray[i]);
        }
        for(int i = 0; i < strArray.length; i++){
            bookList.add(  new Book(bookList.size()+1, strArray[i], false));
        }

        for(int i = 0; i < bookList.size(); i++){
            System.out.println(bookList.get(i));
        }

    }

    private static Library instance = new Library();

    public static Library getInstance(){
        return instance;
    }

    // 책 목록 출력 메소드
    public void printBook(){
        for(Book bo : bookList){
            System.out.println(bo);
        }
    }

    // 책 대여 메소드
    public void borrow(int no){
        // booklist에 담긴 Book 겍체중에 필두변수 no 값이
        // 파라미터로 들어온 no값과 같은 녀석을 찾고,
        // 해당 Book 객체의 isBorrow 값을 true로 바꾼다.
        for(Book bo : bookList){
            if(bo.getNo() == no){
                bo.setBorrow(true);
                System.out.println(bo.getTitle() + "을 대여하였습니다.");
                return;
            }
        }
        System.out.println("해당 책이 존재하지 않습니다.");
    }

    // 책 반납 메소드

    public void back(int no){
        // booklist에 담긴 Book 겍체중에 필두변수 no 값이
        // 파라미터로 들어온 no값과 같은 녀석을 찾고,
        // 해당 Book 객체의 isBorrow 값을 false로 바꾼다.
        for(Book bo : bookList){
            if(bo.getNo() == no){
                bo.setBorrow(false);
                System.out.println(bo.getTitle() + "가 입고되었습니다.");
            }
        }
    }

    // 책 검색 메소드
    public void searchBook(String keword){
        // bookList를 순회하면서 각각의 Book 객체의 title에
        // keyword가 포함되어 있으면 출력
        for(Book bo : bookList){
//            bo.getTitle().contains(keword);
            if(bo.getTitle().indexOf(keword) != -1){
                System.out.println(bo);
            };
        }
    }




}
