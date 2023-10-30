package kangyeon.submit11.q02;

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

        System.out.println("\n====================================================\n");

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
       /* for(int i = 0; i < dbList.size(); i++){
            System.out.println(dbList.get(i));
        }*/
        // 향상된 for문
        for(DateBoard date : dbList){
            System.out.println(date);
        }

        System.out.println("\n====================================================\n");

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

        System.out.println("\n====================================================\n");

        // 최근 한달 내 작성된 게시글만 출력

        Date today = new Date();
        long longToday = today.getTime();  // System.currentTimeMillis()

        // 30일을 밀리세컨드로 변환
        long thirty = 1000l * 60 * 60 *24 * 30;
        System.out.println(thirty);

        for(int i = 0; i < dbList.size() - 1; i++){
            long a = (sdf.parse(dbList.get(i).getDate())).getTime();
            if(longToday - a <= thirty){
                System.out.println(dbList.get(i));
            }
        }

        // 오늘이 10.27이면 9.27이 국룰
        // 오늘 날짜 기준인 Calendar로부터 한달을 빼고
        // 한달 뺀 Calendar로부터 그 long타입 날짜를 구한뒤
        // = 한달 전 long 타입 날짜
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        System.out.println(sdf.format(cal.getTime()));

        for(int i =  0; i < dbList.size(); i++){
            Date temp = sdf.parse(dbList.get(i).getDate());

            if(cal.getTime().getTime() <= temp.getTime()){
                System.out.println(dbList.get(i));
            }
        }

        System.out.println("\n====================================================\n");

        // 2023 10. 1에 대한 밀리세컨드
        Calendar startCal = Calendar.getInstance();
        startCal.set(2023, 9, 1, 00, 00, 00);
        Date startDate = startCal.getTime();
        long startLong = startDate.getTime();

        // 10월 마지막날 구하기 + 밀리세컨드로 변환
        int lastDay = startCal.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(lastDay);

        Calendar lastCal = Calendar.getInstance();
        lastCal.set(2023,10,1,00,00,00);
        Date lastDate = lastCal.getTime();
        long lastLong = lastDate.getTime();

        System.out.println("\n====================================================\n");

        // 이번달(10월)에 작성한 글 확인
        for(int i = 0; i < dbList.size(); i++){
            long curMonDate = sdf.parse(dbList.get(i).getDate()).getTime();
            if(startLong < curMonDate && curMonDate < lastLong){
                System.out.println(dbList.get(i));
            }
        }

        System.out.println("\n====================================================\n");

        // 6월에 작성한 글 확인

        // 2023 6. 1에 대한 밀리세컨드
        startCal = Calendar.getInstance();
        startCal.set(2023, 5, 1, 00, 00, 00);
        startDate = startCal.getTime();
        startLong = startDate.getTime();

        // 6월 마지막날 구하기 + 밀리세컨드로 변환
        lastDay = startCal.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(lastDay);

        lastCal = Calendar.getInstance();
        lastCal.set(2023,6,1,00,00,00);
        lastDate = lastCal.getTime();
        lastLong = lastDate.getTime();

        // 이번달(6월)에 작성한 글 확인
        for(int i = 0; i < dbList.size(); i++){
            long curMonDate = sdf.parse(dbList.get(i).getDate()).getTime();
            if(startLong < curMonDate && curMonDate < lastLong){
                System.out.println(dbList.get(i));
            }
        }

        System.out.println("\n====================================================\n");

        // 2023년 7월 14일부터 2023년 8월 21일까지 작성된 게시글

        // 2023 7. 14에 대한 밀리세컨드
        startCal = Calendar.getInstance();
        startCal.set(2023, 6, 14, 00, 00, 00);
        startDate = startCal.getTime();
        startLong = startDate.getTime();

        lastCal = Calendar.getInstance();
        lastCal.set(2023,7,22,00,00,00);
        lastDate = lastCal.getTime();
        lastLong = lastDate.getTime();

        // 기간 내에 작성한 글 확인
        for(int i = 0; i < dbList.size(); i++){
            long curMonDate = sdf.parse(dbList.get(i).getDate()).getTime();
            if(startLong < curMonDate && curMonDate < lastLong){
                System.out.println(dbList.get(i));
            }
        }























    }
}
