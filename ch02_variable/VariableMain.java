package ch02_variable;

public class VariableMain {

    public static void main(String[] args) {
        // 변수(Variable)의 선언
        // [변수 타입] [변수명] 의 형태
        int myMoney; // 변수가 선언됨 -> 메모리에 변수명이 등록됨

        // 변수에 값을 담지 않은 경우 사용할 수 없다.
        // 해당 커서 주석 처리/해제 [Ctrl + /]
//         System.out.println(myMoney);

        // 변수에 값 할당
        // 변수에 값을 할당하는 작업에 대해
        // 변수 초기화(Initialization = Init)라고 한다.
        // 등호(=)를 이용하여 변수에 값을 담을 수 있다.
        // 등호 오른쪽의 값을 왼쪽에 담는 기능 수행
        myMoney = 10000;
        System.out.println(myMoney);

        // 변수의 값 변경 (값의 변경할 수 있으므로 변수라고 부름)
        myMoney = 100000;
        System.out.println(myMoney);

        // 변수의 선언과 함께 값을 할당
        int number = 10;

        // 변수의 타입
        // 정수 타입
        byte byteNum = 5;
        short shortNum = 5000;
        int intNum = 30000;
        // 21억을 초과하는 숫자에 대해 뒤에 L을 붙여주어야
        // long 타입으로 인식함
        long longNum = 456481653138448612L;

        // 소수 타입
        // 그냥 소수 3.14334 를 입력하게 되면 double 타입으로 인식
        float pi = 3.141592f;  // 뒤에 f를 붙여주어야 float로 인식
        double doubleNum = 100.34234;

        // 불리언 타입 (true/false만 담을 수 있다)
        boolean isGood = false;
        System.out.println(isGood);

        // 변수의 다중 선언
        int numOne, numTwo;
        numOne = 1;
        numTwo = 2;

        // 다중 선언과 동시에 값을 부여할 수 없다 (JAVA에서는)
        // 이게 가능한 프로그래밍 언어도 존재한다. (Python)
//        int a, b, c = 4, 5, 6;

        // 상수의 선언
        // 변수 선언 방식 앞에 final을 붙여준다.
        final double MATE_PI = 3.141592;
        System.out.println(MATE_PI);

        // 상수는 값을 바꿀 수 없다.
        // = 바뀔 일이 없는 값을 상수에 담아서 사용한다
//        MATH_PI = 4.1;

        System.out.println("\n================\n");

        // 변수를 사용하는 이유

        // 콘솔창에 숫자 32를 10번 출력해보기
        // 같은 값을 여기저기서 사용하는 경우 변수에 담아서
        // 사용하는 것이 편하다.
        int a = 32;


        System.out.println(a);
        System.out.println(a);
        System.out.println(a);
        System.out.println(a);
        System.out.println(a);
        System.out.println(a);
        System.out.println(a);
        System.out.println(a);
        System.out.println(a);
        System.out.println(a);

        // 값에 대한 이름을 부여할 수 있다.
        int gangyeonAge = 30;
        System.out.println(gangyeonAge);

        System.out.println("\n========== char ============\n");

        // char 는 문자를 담는데 사용된다.
        // 유니코드에 등록된 각 문자들의 넘버링을 담을 수 있다.
        // 작은 따옴표 ('') 안에 하나의 문자를 담을 수도 있다.

        // A는 유니코드에서 65번째 위치
        char numA = 65;
        System.out.println(numA);

        char wordA = 'A';
        System.out.println(wordA);

        wordA++;
        System.out.println(wordA);

        // 한글 '가'는 유니코드에서 44032번째에 위치
        char hangul = 44032;
        System.out.println(hangul);

        // 1을 더한다.
        hangul++;
        System.out.println(hangul);

        // byte 는 -128 부터 127까지 담을 수 있다.
        byte byteNumber = 127;

        byteNumber++;
        System.out.println(byteNumber);


    }

}