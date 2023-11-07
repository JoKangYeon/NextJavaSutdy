package ch15_inout;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NotePad {

    public static void main(String[] args) {
        // 포로그램 실행 시
        // 파일명과 내용을 입력받아
        // /home/pc11/stuList 폴더 내에 해당 파일명으로 입력한
        // 내용이 들어간 텍스트 파일 생성하기

        Scanner scan = new Scanner(System.in);

        System.out.println("제목을 입력해주세요.");
        System.out.print(">>> ");
        String title = scan.nextLine();
        File input = new File("/home/pc11/stuList/" + title + ".txt");

        System.out.println("내용을 입력해주세요.");
        System.out.print(">>> ");
        String content = scan.nextLine();

        try(FileWriter writer = new FileWriter(input, true);){
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
