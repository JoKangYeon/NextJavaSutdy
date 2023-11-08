package ch16_network.socket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

// 연결된 소켓 객체의 OutputStream 에다
// 문구를 작성하여 보내는 클래스
public class SendThread extends Thread{

    private Socket soc;     /* 연결된 소켓 객체를 담을 그릇 */

    public SendThread(Socket soc){
        this.soc = soc;
    }

    @Override
    public void run() {
        // 멀티쓰레드로 일을 시키면 실행되는 영역
        // 콘솔창에 키보드로 입력한 내용을 소켓의
        // OutputStream에 입력 후 보내기
        Scanner scan = new Scanner(System.in);



        // 연결된 소켓의 outputStream 가져오기
        try {
            PrintWriter writer = new PrintWriter(soc.getOutputStream()/*, true*/);
            // 위방법으로 PrintWriter 썼는데 한글이 깨져서 전달된다면 인코딩 설정하기
//            PrintWriter writer = new PrintWriter(new OutputStreamWriter(soc.getOutputStream(), "UTF-8"));

            System.out.print("닉네임 입력: ");
            String name = scan.nextLine();
            writer.println(name + "님이 입장하셨습니다.");
            writer.flush();

            while(true){
                System.out.print(">>> ");
                String msg = scan.nextLine();
                System.out.println(msg);

                // 채팅창에 exit을 입력 시 채팅종료(나가기) -> 소켓 통신 종료 -> 소켓 객체 close() 해주기
                if(msg.equals("exit")){
                    break;
                }

                // outputStream에 텍스트 작성
                writer.println(name + ": " + msg);    // msg 문자열뒤에 자동으로 개행문자(\n)를 붙여서 보낸다.
                // 작성된 텍스트 전송
                writer.flush();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(soc != null){ try { soc.close(); } catch (IOException e) {} }
        }


    }
}
