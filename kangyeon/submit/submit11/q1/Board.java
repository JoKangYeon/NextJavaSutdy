package kangyeon.submit.submit11;

public class Board {
    private int no;             /* 글번호 */
    private String title;       /* 글제목 */
    private String creatBoard;  /* 글게시일 */
    private String content;     /* 글내용 */

    public Board() {
    }

    public Board(int no, String title, String creatBoard, String content) {
        this.no = no;
        this.title = title;
        this.creatBoard = creatBoard;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Board{" +
                "no=" + no +
                ", title='" + title + '\'' +
                ", creatBoard='" + creatBoard + '\'' +
                ", content='" + content + '\'' +
                '}';
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

    public String getCreatBoard() {
        return creatBoard;
    }

    public void setCreatBoard(String creatBoard) {
        this.creatBoard = creatBoard;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
