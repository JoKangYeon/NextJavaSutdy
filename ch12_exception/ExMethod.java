package ch12_exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExMethod {

    // 날짜 문자열을 입력하면 밀리초로 바꿔서 리턴
    // yyyy.MM.dd 로 들어와야 함
    public static long dateTOMillSec(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        // 패턴과 다른 형태의 문자열이 파라미터로 들어오면 ParseException이 발생
        // 해당 에러에 대한 처리를 여기서 할거면 try - catch 사용
        // 해당 에러에 대한 처리를 여기서 안할거면 throws 를 이용하여 던진다.
        // => 이후 dateToMillSec 메소드를 사용하는 곳에서 try - catch 사용해야 함
            Date result = sdf.parse(date);
            return result.getTime();
    }

    // 파라미터로 0이 들어오면 가위 리턴
    // 파라미터로 1이 들어오면 바위 리턴
    // 파라미터로 2이 들어오면 보 리턴
    public static String game(int num) throws Exception {
        if(num == 0){
            return "가위";
        }else if(num == 1){
            return "바위";
        }else if(num == 2){
            return "보";
        }else{
            // 에러 발생시키기
            // Exception을 상속받는 예외 클래스 객체를 생성하면서 던진다.
            throw new Exception("파라미터에 0부터 2사이의 숫자를 넣어주세요.");
        }
    }

    // 입력받은 이름을 콘솔창에 출력
    // 파라미터로 들어온 문자열이 숫자이거나, empty면 안됨
    public static void printName(String name) throws BizException{

        if(name.length() == 0){
            throw new BizException(ExCode.API_001, "빈 문자열은 안됩니다.");
        }else if(name.matches("^[0-9]+$")){
            throw new BizException(ExCode.API_002, "숫자는 안됩니다.");
        }else{
            System.out.println(name);
        }
    }





}
