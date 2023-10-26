package kangyeon.submit.submit11.q2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

public class DateBoardMain {

    public static void main(String[] args) throws ParseException {

        // dbList에 랜덤 날짜를 가지는 DateBoard 객체 100개 삽입
        ArrayList<DateBoard> dbList = new ArrayList<DateBoard>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

        for(int i = 0; i < 100; i++) {
            int randDay = (int)(Math.random() * 365) + 1;		// 1~365
            Calendar cal = Calendar.getInstance(); // 오늘날짜
            cal.add(Calendar.DATE, randDay * -1); // 오늘날짜에서 1~365 중 랜덤한 일수를 뺀다.

            String strDate = sdf.format(cal.getTime());
            dbList.add(new DateBoard((i+1) + "번째 생성된 글", strDate));
        }

       /* for(int i = 0; i < dbList.size(); i++) {
            System.out.println(dbList.get(i));
        }*/

        // TODO 코드작성 시작 ~!!

        // 최신순
        for(int k = 0; k < dbList.size() - 1; k++){
            for(int i = 0; i < dbList.size() - 1; i++){
                long left = (sdf.parse(dbList.get(i).getDate())).getTime();
                long right = (sdf.parse(dbList.get(i+1).getDate())).getTime();
                if(left < right){
                    DateBoard tmp = dbList.get(i);
                    dbList.set(i, dbList.get(i+1));
                    dbList.set(i+1, tmp);
                }
            }
        }
        for(int i = 0; i < dbList.size(); i++){
            System.out.println(dbList.get(i));
        }

        // 오래된 순
        for(int k = 0; k < dbList.size() - 1; k++){
            for(int i = 0; i < dbList.size() - 1; i++){
                long left = (sdf.parse(dbList.get(i).getDate())).getTime();
                long right = (sdf.parse(dbList.get(i+1).getDate())).getTime();
                if(left > right){
                    DateBoard tmp = dbList.get(i);
                    dbList.set(i, dbList.get(i+1));
                    dbList.set(i+1, tmp);
                }
            }
        }
        for(int i = 0; i < dbList.size(); i++){
            System.out.println(dbList.get(i));
        }

        // 최근 한달 내 작성된 게시글만 출력

        Date today = new Date();
        long longToday = today.getTime();

        // 30일을 밀리세컨드로 변환
        long thirty = 1000l * 60 * 60 *24 * 30;
        System.out.println(thirty);

        for(int i = 0; i < dbList.size() - 1; i++){
            long a = (sdf.parse(dbList.get(i).getDate())).getTime();
            if(longToday - a <= thirty){
                System.out.println(dbList.get(i));
            }
        }

















    }
}
