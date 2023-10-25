package ch11_java_api;

import java.util.regex.Pattern;

public class Apipattern {

    public static void main(String[] args) {
        // 정규표현식(Regular Expression)
        // 특정한 규칙을 가진 문자열의 집합을 표현하기 위해 쓰는 형식

        // 숫자만 존재하는지 검증(유효성 검증, Validation)
        String example = "123a312";
        String regex = "^[0-9]+$";

        // 검사 결과에 대한 true/false 리턴
        boolean result = Pattern.matches(regex, example);
        System.out.println(example + "의 검증 " + regex + " 결과 " + result);

        // String 클래스 내부에 Pattern.matches()를 적용한 matches 메소드가 만들어져있음
        System.out.println(example.matches(regex));

        // 알파벳만 존재하는지 검증
        example = "Jeong Chanung";
        regex = "^[a-zA-z\\s ]+$";  // \\s는 띄어쓰기 문자를 의미
        System.out.println(example + "의 검증 " + regex + " 결과 " + example.matches(regex));

        // 한글만 존재하는지 검증
        example = "조강연";
        regex = "^[ㄱ-ㅎ가-힣]+$";
        System.out.println(example + "의 검증 " + regex + " 결과 " + example.matches(regex));

        // 아이디패턴
        // 영어와 숫자로만 구성
        // 아이디는 7글자 이상 12글자 이하여야 한다
        example = "akow283";
        regex = "^[a-zA-Z0-9]{7,12}$";
        regex ="^\\w{7,12}$";   // [a-zA-Z0-9]의 축약형 \\w
        System.out.println(example + "의 검증 " + regex + " 결과 " + example.matches(regex));

        // 비밀번호 패턴
        // 영어와 숫자 + 특수문자
        example = "akow283!";
        regex = "^[\\w!@#$%^&*$]+";
        System.out.println(example + "의 검증 " + regex + " 결과 " + example.matches(regex));

        // 영어 소문자, 대문자, 숫자, 특수문자 1개 이상
        // 8~16 글자 사이여야한다.
        example = "Akow283!";
        regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()|=]{8,16}$";
        System.out.println(example + "의 검증 " + regex + " 결과 확인" + example.matches(regex));

        // PIN 비밀번호 설정 시
        // 6자리 숫자 중 동일한 숫자 연달아 3개이상 금지
        example = "233346";
        regex = "^.*(\\d)\\1\\1.*$";
        System.out.println(example + "의 검증 " + regex + " 결과 " + example.matches(regex));

        if(!example.matches(regex)){
            regex = "^[0-9]{6}$";   // 6자리 숫자인지 체크
            if(example.matches(regex)){
                System.out.println("동일한 숫자가 반복되지 않고 6자리임 !!");
            }
        }

        // 이메일 형식 체크
        example = "akow283@gmail.com";
        regex = "^[\\w]+[@][a-zA-Z]+[.][a-zA-Z]+$";
        System.out.println(example + "의 검증 " + regex + " 결과 " + example.matches(regex));


    }
}
