package kangyeon.submit11.q01;

import java.util.ArrayList;

public class BoardDB {
    private ArrayList<Board> boardList = new ArrayList<>();

    private BoardDB() {
    }

    private static BoardDB instance = new BoardDB();

    public static BoardDB getInstance() {
        return instance;
    }

    public void toWrite(String a, String b, String c){
        boardList.add(new Board(boardList.size(), a, b,c));
    }

    public void showList(){
        for(int i = 0; i < boardList.size(); i++){
            System.out.println("1. | " + boardList.get(i).getTitle() +  " | " + boardList.get(i).getCreatBoard());
        }
    }
}
