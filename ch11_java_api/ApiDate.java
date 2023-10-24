package ch11_java_api;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class ApiDate {

    public static void main(String[] args) throws ParseException {
        // API 란? 완성된, 만들어져 있는 코드를 가져다 쓰는 것
        // SDK 란? 프로그램 로직, 기술이 만들어져 있으나
        // 그냥 가져다 쓰기보다는 가지고 와서 추가적인 개발을
        // 해서 써야하는 것

        // JDK 안에 만들어져 있는 API 들 배우기

        // 현재 시간 구하기
        // 1. Date 클래스 사용
        Date dateToday = new Date();

        // Date 객체가 생성될 때 (= new Date() 실행)
        // Date 객체 내부에 new Date()가 실행되었을 때의 시간이
        // 저장된다.

        // Tue Oct 24 10:26:55 KST 2023
        System.out.println(dateToday);

        // 날짜 포맷을 이용하여
        // 2023-10-24 10:26:55 형태로 바꾸기
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // sdf.format(Date 갹체) 는 Date 객체에 저장된 날짜를
        // 정해둔 날짜 포맷 형식으로 변환한 문자열을 리턴
        String strToday = sdf.format(dateToday);
        System.out.println(strToday);

        System.out.println("\n============================================\n");

        // 2. Calendar 클래스 사용
        // .getInstance() 실행 시 새로운 객체가 생성된다.
        // 객체가 생성될 때의 시간이 저장된다.
        Calendar calToday = Calendar.getInstance();

        System.out.println(calToday);

        // Calendar 객체에서 Date 객체 꺼내기
        Date calToDate = calToday.getTime();
        System.out.println(calToDate);
        System.out.println(sdf.format(calToDate));
        System.out.println(sdf.format(calToDate.getTime()));

        System.out.println("\n============================================\n");

        // 3. System 클래스 사용
        // 현재 시간에 대해 밀리초 단위로 리턴
        // 1970년 1월 1일 0시부터 현재까지 경과된 시간을 밀리초 단위로 리턴
        long longToday = System.currentTimeMillis();
        System.out.println(longToday);

        // 날짜 포맷팅
        System.out.println(sdf.format(longToday));
        System.out.println( sdf.format(0l));

        System.out.println("\n============================================\n");

        // 다양한 날짜 타입 만들기
        // 1. 2023/10/24 11:04:30
        // 2. 23-10-24 오전 11:04:30
        // 3. 화요일 11:04:30
        // @ 2023.10.24 AM 11:04:30

        // 1. 2023/10/24 11:04:30
        sdf= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println(sdf.format((new Date())));
        // hh -> 0~12라서 오후 2시면 02로 표현
        // h -> 오전 3시면 3, 오후 4시면 4로 표현 (한자리 숫자에 대해 앞에 0이 안붙음)
        // HH -> 0~24 라서 오후 2시면 14로 표현
        // yyyy -> 2023, yy -> 23
        // MM -> 7월이면 07로 표현, M -> 7월이면 7로 표현

        // 2. 23-10-24 오전 11:04:30
        // 2. 23-10-24 오후 02:04:30
        sdf = new SimpleDateFormat("yy-MM-dd a hh:mm:ss");
        System.out.println(sdf.format(new Date()));

        // 3. 화요일 11:04:30
        sdf = new SimpleDateFormat("E요일 HH:mm:ss");
        System.out.println(sdf.format(new Date()));

        //  @ 2023.10.24 AM 11:04:30
        sdf = new SimpleDateFormat("yyyy.MM.dd a hh:mm:ss", Locale.US);
        System.out.println(sdf.format(new Date()));

        // @ 현재 미국날짜를 2023.10.24 AM 01:04:30 로 출력하기

        TimeZone time;
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy.MM.dd a hh:mm:ss");

        time = TimeZone.getTimeZone("America/Los_Angeles");
        df.setTimeZone(time);
        System.out.println(df.format((new Date())));

        // 보고싶은 시간
        String[] local = TimeZone.getAvailableIDs();
        for (int i = 0; i < local.length; i++) {
            System.out.println(local[i]);
        }

        System.out.println("\n============================================\n");

        // 날짜형 문자열(String) -> Date 객체로 변환
        String strTomorrow = "2023-10-25 20:12:45";

        // SimpleDateFormat 에 문자열과 같은 형태의 포멧 설정
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 해당 날짜형 문자열의 날짜가 저장된 Date 객체 리턴
        // sdf의 날짜 포멧과 날짜형 문자열의 형식이 하나라도 다르면 에러 발생
        Date dateTomorrow = sdf.parse(strTomorrow);

        System.out.println(dateTomorrow);

        String strTime = "11:48:32";
        sdf = new SimpleDateFormat("HH:mm:ss");
        Date dateTime = sdf.parse(strTime);
        System.out.println(dateTime);   // Thu Jan 01 11:48:32 KST 1970

        String strYear = "2023.10.20";
        sdf = new SimpleDateFormat("yyyy.MM.dd");
        Date dateYear = sdf.parse(strYear);
        System.out.println(dateYear);   // Fri Oct 20 00:00:00 KST 2023

        // 날짜 세팅하기
        // 여기서 month 부분은 1월이 0, 2월이 1,  ..., 12월 11
        Calendar cal = Calendar.getInstance();

        cal.set(1998, 11, 2, 14, 20, 20);

        sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        System.out.println(sdf.format((cal.getTime())));

        // Date 타입의 객체를 Calendar 타입으로 변환
        Date temp = new Date();
        Calendar calTemp = Calendar.getInstance();
        calTemp.setTime(dateTomorrow);  // Date 객체의 시간이 Calendar 객체에 저장된다.

        // 2023.10.25 20:12:45
        System.out.println(sdf.format(calTemp.getTime()));

        // 날짜 꺼내기

        // 년도
        System.out.println(calTemp.get(Calendar.YEAR)); // 1이라는 숫자에 대해 네이밍이 주어진 상태
//        System.out.println(calTemp.get(1));
        // 월
        System.out.println(calTemp.get(Calendar.MONTH) + 1);
//        System.out.println(calTemp.get(2));
        // 일
        System.out.println(calTemp.get(Calendar.DATE));
        // 시간
        System.out.println(calTemp.get(Calendar.HOUR)); // 8
        System.out.println(calTemp.get(Calendar.HOUR_OF_DAY));  // 20
        // 분
        System.out.println(calTemp.get(Calendar.MINUTE));
        // 초
        System.out.println(calTemp.get(Calendar.SECOND));

        System.out.println("\n============================================\n");

        // 날짜 연산
        String oneDay = "2023.10.24 12:21:32";
        String twoDay = "2023.11.21 11:11:22";

        sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        Date oneDate = sdf.parse(oneDay);
        Date twoDate = sdf.parse(twoDay);

        // Date 객체에 .getTime() 하면 그 밀리초(long)가 나옴
        System.out.println(oneDate.getTime());
        System.out.println(twoDate.getTime());

        long diffMillSec = twoDate.getTime() - oneDate.getTime();
        System.out.println(diffMillSec + "밀리초 차이");

        // 1초 = 1000밀리초
        // diffMillSec / 1000 => 초단위
        long diffSec = diffMillSec / 1000;
        System.out.println(diffSec + "초 차이");

        // 1분 = 60초
        // diffSec / 60 => 분단위
        long diffMin = diffSec / 60;
        System.out.println(diffMin + "분 차이");

        // 1시간 = 60분
        // diffMin / 60 => 시간 단위
        long diffHour = diffMin / 60;
        System.out.println(diffHour + "시간 차이");

        // 1일 = 24시간
        // diffHour / 24 => 일 단위
        long diffDate = diffHour / 24;
        System.out.println(diffDate + "일 차이");

        // 한줄로 며칠 차이인지 확인
        long diff = diffMillSec / 1000 / 60 / 60 / 24;
//        long diff = diffMillSec / (1000 * 60 * 60 * 24);
        System.out.println(diff + "일 차이");

        // 디데이 계산기
        // 2023.09.18 에 대해 +36
        // 2023.11.03 에 대해 -10
        // 이 출력되는 디데이 계산기를 만들어보기

        // 오늘 날짜에 대한 Date 객체 생성 후
        // 1. welcomeDay와 날짜 연산
        // 2. together와 날짜 연산

        Date today = new Date();
        Calendar calTemp1 = Calendar.getInstance();
        calTemp.setTime(today);

        String welcomeDay = "2023.09.18";
        String together = "2023.11.03";

        sdf = new SimpleDateFormat("yyyy.MM.dd");
        Date welDate = sdf.parse(welcomeDay);
        Date togeDate = sdf.parse(together);

        long diffWelDay = welDate.getTime() - today.getTime();
        System.out.println(diffWelDay);


















    }
}
