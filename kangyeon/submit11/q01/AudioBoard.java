package kangyeon.submit11.q01;

public class AudioBoard extends Board{
    private String audio;       /* 오디오 */

    public AudioBoard(String audio) {
        this.audio = audio;
    }

    public AudioBoard(int no, String title, String creatBoard, String content, String audio) {
        super(no, title, creatBoard, content);
        this.audio = audio;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }
}
