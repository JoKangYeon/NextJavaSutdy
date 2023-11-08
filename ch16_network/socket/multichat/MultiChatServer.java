package ch16_network.socket.multichat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiChatServer {

    public static ArrayList<Client> clientList = new ArrayList<>();

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(9002);

            while(true){
                Socket connectionSocket = server.accept();
                System.out.println("연결 수락: " + connectionSocket.getRemoteSocketAddress());

                Client client = new Client(connectionSocket);
                client.start();
                clientList.add(client);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}