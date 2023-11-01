package cgv;

public class Movie {
    private String title;
    private String myReview;

    public Movie() {
    }

    public Movie(String title, String myReview) {
        this.title = title;
        this.myReview = myReview;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", myReview='" + myReview + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMyReview() {
        return myReview;
    }

    public void setMyReview(String myReview) {
        this.myReview = myReview;
    }

}
