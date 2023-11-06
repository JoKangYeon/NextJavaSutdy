package ch15_inout;

import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {

    public static void main(String[] args) {

        try(FileWriter writer = new FileWriter("/home/pc11/stuList/total.txt", true);) {

            String msg = "세번째로 하고 싶은 말\n";
            writer.write(msg);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
