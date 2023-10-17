package kangyeon.submit.submit10;

public class Book {
    private int no;          /* 도서 번호 */
    private String title;       /* 도서 제목 */
    private boolean borrow;      /* 대여 여부 */

    public Book() {
    }

    public Book(int no, String title) {
        this.no = no;
        this.title = title;
    }

    public Book(int no, String title, boolean aFalse) {
        this.no = no;
        this.title = title;
        this.borrow = aFalse;
    }

    @Override
    public String toString() {
        return "Book[" +
                "도서번호='" + no + '\'' +
                ", 도서제목='" + title + '\'' +
                ", 대여여부=" + borrow +
                ']';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isFalse() {
        return borrow;
    }

    public void setFalse(boolean aFalse) {
        borrow = aFalse;
    }


}
