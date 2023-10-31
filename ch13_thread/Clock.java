package ch13_thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Clock {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        Thread th = new Thread(() -> {
            while (true) {
                String time = sdf.format(new Date());
                System.out.println(time);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        th.start();




        Scanner scan = new Scanner(System.in);

        while(true){
            System.out.print(">>> ");

            String input = scan.nextLine();

            System.out.println(input);
        }


















































    }
}
