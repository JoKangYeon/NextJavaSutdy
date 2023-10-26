package ch11_java_api;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static project01.getarea.AreaDB.exit;
import static project01.getarea.AreaDB.red;

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


        String welcomeDay = "2023.09.18";
        String together = "2023.11.03";

        sdf = new SimpleDateFormat("yyyy.MM.dd");
        Date welDate = sdf.parse(welcomeDay);
        Date togeDate = sdf.parse(together);

        Date today = new Date();
        String sToday = sdf.format((today));    // 2023.10.25
        System.out.println(sToday);

        // sdf로 포맷하면 시,분,초가 00:00:00 으로 바뀜
        today = sdf.parse(sToday);
        System.out.println(today);

        // 과거랑 현재의 계산 37일 + 시간인데 시간이 삭제되고 37출력  현재 10월 25일 오전9시
        long diffWelDay = today.getTime() - welDate.getTime();
        System.out.println(diffWelDay / (1000 * 60 * 60 * 24) + "일 지남");

        // 현재와 미래의 계산
        // today에 시/분/초 가 00:00:00이 되어야 함
        long difftogeDay = today.getTime() - togeDate.getTime();
        System.out.println(difftogeDay / (1000 * 60 * 60 * 24) + "일 남음");

        System.out.println("\n============================================\n");

        // Calendar 날짜 연산
        // 특정 날짜를 기준으로 날짜를 더하거나 뺄 때 유용
        Calendar toCal = Calendar.getInstance();
        System.out.println(sdf.format(toCal.getTime()));

        // 3일 뒤
        toCal.add(Calendar.DATE, 3);
        System.out.println(sdf.format(toCal.getTime()));

        // 20일 뒤
        toCal.add(Calendar.DATE, 20);
        System.out.println(sdf.format(toCal.getTime()));

        // 7일 전
        toCal.add(Calendar.DATE, -7);
        System.out.println(sdf.format(toCal.getTime()));

        // 10달 뒤
        toCal.add(Calendar.MONTH, 10);
        System.out.println(sdf.format(toCal.getTime()));

        System.out.println("\n============================================\n");

        // 달력 만들기
        int year = 2023;
        int month = 10;

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month-1, 1);
        System.out.println(sdf.format(calendar.getTime()));

        // 1일이 무슨 요일에 시작하는지 알아야 함
        // 1: 일요일, 2: 월요일, 3: 화요일 ..., 7: 토요일
        int startDay = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(startDay);

        // 해당 월의 마지막 일자가 몇인지 알아야 함
        int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(lastDay);

        System.out.println(year + "년" + month + "월 달력");
        System.out.println("일\t월\t화\t수\t목\t금\t토");
        for(int i = 1; i <= 42; i++){
            // i가 startDay보다 작으면 출력안함
            if(i < startDay){
                System.out.print("\t");
            }else{
                // startDay가 3이라면
                // i 는 3일 때 처음 들어온다.
                // i = 3 -> 1
                // i = 4 -> 2
                // i = 5 -> 3

                // start Day가 4라면
                // i 는 4일 때 처음 들어온다.
                // i = 4 -> 1
                // i = 5 -> 2
                // i = 6 -> 3
                // i - startDay + 1
                int currentDay = i - startDay + 1;

                // currentDay가 lastDay보다 크면  for문 종료
                if(currentDay > lastDay){
                    break;
                }

                System.out.printf(("%2d\t"), currentDay);
            }

            // i가 7, 14, 21, 28, ... 일 때 줄바꾸기
            if(i % 7 == 0){
                System.out.println();
            }

        }

        System.out.println("\n============================================\n");

        // 주말이 제외된 달력을 만들어보기

        // 달력 만들기
        year = 2023;
        month = 9;

        Calendar calendar2 = Calendar.getInstance();
        calendar.set(year, month-1, 1);
        System.out.println(sdf.format(calendar.getTime()));

        // 1일이 무슨 요일에 시작하는지 알아야 함
        // 1: 일요일, 2: 월요일, 3: 화요일 ..., 7: 토요일
        startDay = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(startDay);

        // 해당 월의 마지막 일자가 몇인지 알아야 함
        lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(lastDay);

        System.out.println(year + "년" + month + "월 달력");
        System.out.println("월\t화\t수\t목\t금");
        for(int i = 1; i <= 42; i++){
            // i가 startDay보다 작으면 출력안함
            if(i < startDay && i > 1){
                // i가 1일때 일요일인데도 탭이 추가된다.
                System.out.print("\t");
            }else{

                int currentDay = i - startDay + 1;

                // currentDay가 lastDay보다 크면  for문 종료
                if(currentDay > lastDay){
                    break;
                }
                // 숫자를 그리는 부분
                // 일, 토요일은 그리지 않도록
                // i % 7 == 0 일 때 그리지 않음
                // 또 i % 7 == 1 일때도 그리지않음
                // i % 7 == 0 또는 i % 7 == 1이 아닌 경우에만 그린다.
                if(!(i % 7 == 0 || i % 7 == 1)){
                    System.out.printf(("%2d\t"), currentDay);
                }
            }

            // i가 7, 14, 21, 28, ... 일 때 줄바꾸기
            if(i % 7 == 0){
                System.out.println();
            }

        }


        // 꽉찬 달력 만들기
        year = 2023;
        month = 9;

        Calendar numCalendar = Calendar.getInstance();
        Calendar numCalendar2 = Calendar.getInstance();
        Calendar numCalendar3 = Calendar.getInstance();
        numCalendar.set(year, month - 1, 1);
        numCalendar2.set(year, month - 2, 1);
        numCalendar3.set(year, month, 1);
        System.out.println(sdf.format(numCalendar.getTime()));
        System.out.println(sdf.format(numCalendar2.getTime()));

        // 1일이 무슨 요일에 시작하는지 알아야 함
        // 1: 일요일, 2: 월요일, 3: 화요일 ..., 7: 토요일
        startDay = numCalendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(startDay);

        // 해당 월의 마지막 일자가 몇인지 알아야 함
        lastDay = numCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int prelastday = numCalendar2.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(lastDay);
        System.out.println(prelastday);

        System.out.println(year + "년" + month + "월 달력");
        System.out.println("일\t월\t화\t수\t목\t금\t토");

        for(int i = 0; i < 42; i++){
            if(i == 0){

            }
        }
















    }

}

