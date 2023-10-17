package kangyeon.submit.submit10;

public class Book {
    private String no;          /* 도서 번호 */
    private String title;       /* 도서 제목 */
    private boolean False;      /* 대여 여부 */

    public Book() {
    }

    public Book(String title) {
        this.title = title;
    }

    public Book(String no, String title, boolean aFalse) {
        this.no = no;
        this.title = title;
        False = aFalse;
    }

    @Override
    public String toString() {
        return "Book{" +
                "no='" + no + '\'' +
                ", title='" + title + '\'' +
                ", False=" + False +
                '}';
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isFalse() {
        return False;
    }

    public void setFalse(boolean aFalse) {
        False = aFalse;
    }


}
