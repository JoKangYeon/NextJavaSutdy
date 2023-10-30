package kangyeon.submit11.q01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BoardMain {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        BoardDB boardDB = BoardDB.getInstance();


        while(true){
            System.out.println("행동을 선택해주세요.");
            System.out.println("1. 글 목록 | 2. 글 쓰기 | 3. 종료");
            System.out.print(">>> ");
            int command = Integer.parseInt(scan.nextLine());
            if(command == 1){
                boardDB.showList();
            }else if(command == 2){
                System.out.println("글 제목을 입력해주세요: ");
                String title = scan.nextLine();
                System.out.println("글 내용을 입력해주세요: ");
                String content = scan.nextLine();
                Date dateToday = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String today = sdf.format(dateToday);
                boardDB.toWrite(title, today, content);
            }else{
                System.out.println("종료합니다.");
                break;
            }
        }























































    }
}
