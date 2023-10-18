package pj01_kangyeon.avoidmine;

import java.util.ArrayList;

public class Field {

    private String[][] field = {{"①  ", "②  ", "③  ", "④  ", "⑤"}, {"⑥  ", "⑦  ", "⑧  ", "⑨  ", "⑩"}
            , {"⑪  ", "⑫  ", "⑬  ", "⑭  ", "⑮  "}, {"⑯  ", "⑰  ", "⑱  ", "⑲  ", "⑳"}, {"㉑  ", "㉒  ", "㉓  ", "㉔  ", "㉕"}};  /* 필드 */

    private Field() {
    }

    private static Field instance = new Field();

    public static Field getInstance() {
        return instance;
    }

    public static void printArray(String[] strArray) {
        for (int i = 0; i < strArray.length; i++) {
            if (i == strArray.length - 1) {
                System.out.println(strArray[strArray.length - 1]);
                break;
            }
            System.out.print(strArray[i]);
        }

    }









}