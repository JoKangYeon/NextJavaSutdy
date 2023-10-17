package kangyeon.submit.submit10;

import java.util.ArrayList;

public class LibraryMain {

    public static void main(String[] args) {

        String strBooks = "삼국지, 해리포터와 마법사의 돌, 해리포터와 비밀의 방 , 해리포터와 아즈카반의 죄수,해리포터와 불사조 기사단, 해리포터와 혼혈왕자," +
                " 해리포터와 죽음의 성물,어린왕자, 나의 라임 오렌지나무, 이것이 자바다, " +
                "좋은생각, 반지의 제왕: 반지 원정대, 반지의 제왕: 두 개의 탑, 반지의 제왕: 왕의 귀환, 토익보카, 개미";


        String[] infoBook = strBooks.split(", ");
        System.out.println(infoBook[1]);
        Library bookList = Library.getInstance();

        for(int i = 0; i < infoBook.length; i++){
            bookList.getBookList().add(new Book(infoBook[i]));
        }































    }
}
