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
        int sixRand = (int)(Math.random() * (999999 - 100000 + 1) + 100000);
        String result = a + sixRand;

        return result;
    }










}
