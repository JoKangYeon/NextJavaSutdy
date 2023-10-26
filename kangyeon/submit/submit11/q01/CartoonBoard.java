package kangyeon.submit.submit11;

public class CartoonBoard extends Board{
    private String image;       /* 이미지 */

    public CartoonBoard(String image) {
        this.image = image;
    }

    public CartoonBoard(int no, String title, String creatBoard, String content, String image) {
        super(no, title, creatBoard, content);
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

