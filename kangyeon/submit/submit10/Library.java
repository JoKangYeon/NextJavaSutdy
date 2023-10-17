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
}
