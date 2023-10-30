package kangyeon.review.review01.q02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static kangyeon.review.review01.q02.UniqueId.makeUniqueId;

public class UniqueIdMain {

    public static void main(String[] args) throws ParseException {

        String uniqueId = makeUniqueId();
        System.out.println(uniqueId);


    }
}
