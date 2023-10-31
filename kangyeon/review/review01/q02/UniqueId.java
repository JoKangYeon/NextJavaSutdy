package kangyeon.review.review01.q02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UniqueId {

    public static String makeUniqueId(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
        Date todayDate = new Date();
        String a = sdf.format(todayDate).toString();
        String result = "";
        for(int i =0; i < 6; i++){
            int rand = (int)(Math.random() * 10);
            result += rand;

        }


        return a + result;
    }










}
