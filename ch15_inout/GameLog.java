package ch15_inout;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GameLog {

    public static void main(String[] args) {
        // 강화 게임
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        System.out.println("아이디 입력: ");
        String id = scan.nextLine();

        int grade = 1;

        while(true){
            System.out.println("현재 강화: " + grade);
            System.out.println("강화 확률: 80%");
            System.out.println("1. 강화");
            System.out.println("2. 종료");
            System.out.print(">>> ");
            int command = Integer.parseInt(scan.nextLine());

            if(command == 1){
                int rand = (int)(Math.random() * 100) + 1;

                if(rand <= 80){
                    System.out.println("강화 성공");
                    grade++;
                    saveLog(sdf.format(new Date()) + ": " + id + "님이 " + grade + "강 강화에 성공하였습니다." );
                }else{
                    System.out.println("강화 실패ㅋ");
                    saveLog(sdf.format(new Date()) + ": " + id + "님이 " + grade + "강 강화에 실패하였습니다." );
                }

            }else{
                break;
            }

        }












    }

    public static void saveLog(String log ){
        try(FileWriter writer = new FileWriter("/home/pc11/stuList/gamelog.txt", true);){
            writer.write(log + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }



}
