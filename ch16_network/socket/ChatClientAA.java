package ch16_network.socket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClientAA {
    public static void main(String[] args) {
        String serverAddress = "192.168.0.4"; // Change this to the server's IP or hostname
        int serverPort = 9001;

        try (
                Socket socket = new Socket(serverAddress, serverPort);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                Scanner scanner = new Scanner(System.in)
        ) {
            System.out.println("Connected to the server.");

            // Thread for receiving messages
            Thread receiveThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println("Server: " + message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            receiveThread.start();

            // Thread for sending messages
            Thread sendThread = new Thread(() -> {
                try {
                    String message;
                    while (true) {
                        message = scanner.nextLine();
                        out.println(message);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            sendThread.start();

            // Wait for the threads to finish
            receiveThread.join();
            sendThread.join();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
