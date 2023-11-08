package ch16_network.socket;

import java.io.IOException;
import java.net.Socket;

public class ChatClient {

    public static void main(String[] args) {

        // ChatServer를 실행중인 PC에 소켓 통신 요청을 하는 클래스
        // 생성자에 서버소켓의 IP주소와 Port번호 입력
        try {
            // 서버 소켓에 연결 성공시 연결된 상태의 Socket 객체가 생성된다.
            Socket clientSocket = new Socket("192.168.0.4", 9001);

            SendThread sendThread = new SendThread(clientSocket);
            sendThread.start();

            ReceiveThread receiveThread = new ReceiveThread(clientSocket);
            receiveThread.start();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
