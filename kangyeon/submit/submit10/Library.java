package kangyeon.submit.submit10;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> bookList = new ArrayList<>();

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
        }
        return;
    }

    // 도서 대여 메소드 만들기
    public void outBook(int a){
        Book temp = instance.getBookList().get(a - 1);
        if(temp.isFalse() == false){
            temp.setFalse(true);
        }
        return;
    }

    // 도서 목록 확인 메소드 만들기
    public void checkBook(){
        for (int i = 0; i < instance.getBookList().size(); i++) {
            System.out.println(instance.getBookList().get(i));
        }
    }

    // 도서 목록 검색 메소드 만들기
    public void searchBook(String a){

    }





}
