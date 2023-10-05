package ch06_method;

import java.util.Scanner;

public class MethodMain {
    public static void main(String[] args) {

        // 메소드 = method = 함수 = function
        // 굳이 나누자면
        // 메소드는 클래스에 종속된 함수를 말하며,
        // 함수는 클래스에 독립적인 함수를 말한다. (신경쓰지 않아도 된다)

        // 1부터 100까지 다 더하면 결과는?

        int sum = 0;
        for(int i = 1; i < 101; i++){
            sum += i;
        }
        System.out.println("1부터 100까지 더한 결과: " + sum);

        // 30부터 60까지 다 더하면 결과는?

        sum = 0;
        for(int i = 30; i < 61; i++){
            sum += i;
        }
        System.out.println("30부터 60까지 더한 결과: " + sum);

        // 25부터 50까지 다 더하면 결과는?

        sum = 0;
        for(int i = 25; i < 51; i++){
            sum += i;
        }
        System.out.println("25부터 50까지 더한 결과: " + sum);

        System.out.println("\n=========================================================\n");

        // 위 작업을 메소드로 만들기
        // a부터 b까지 더한 결과는?

        // 함수의 실행 -> 함수명();
        System.out.println("printSum 실행 전");
        printSum(10, 20); // 파라미터에 들어갈 값을 넣어준다.
        System.out.println("printSum 실행 후");

        printSum(70, 90);
        printSum(5, 20);

        // 함수를 쓰면 좋은점
        // 실행부의 코드가 간결해진다(= 가독성이 좋아진다)
        // 중복된 코드를 한 곳에서 관리할 수 있으므로
        // 수정할 때 용이하다!!!

        // 리턴값이 존재하는 함수?
        String fruits = "Apple";
        System.out.println(fruits.substring(1, 3)); // "pp"를 리턴

        // 리턴값이 존재하는 함수 만들기
        returnSum(1, 3); // 실행만 하고 리턴값을 사용하지 않는 상황
        System.out.println(returnSum(1, 3));

        // 리턴값을 변수에 담을 수 있다.
        int num = returnSum(1, 3);
        System.out.println(num);

        // 리턴값이 없으면(void) 변수에 담을 수 없다.
//        int n = ;

        System.out.println("\n=========================================================\n");

        // System.out.println(); 를 파이썬처럼 print() 로 만들어 쓰기
        System.out.println("우리의 println");
        print("우리의 println");

        System.out.println(returnSum(1, 3));
        print(returnSum(1, 3));

        System.out.println("\n=========================================================\n");

        // Math.abs() : 절댓값을 리턴해주는 함수
        int rst = Math.abs(-10);
        System.out.println(rst);

        // 함수명: myabs
        // 파라미터타입 : int
        // 리턴타입: int
        // 파라미터가 음수가들어오면 양수로 바꿔서 리턴
        // 양수가 들어오면 양수 그대로 리
        rst = myAbs(-10);
        System.out.println(rst);

        System.out.println("\n=========================================================\n");

        // makeCard 메소드 만들기
        // 파라미터로 이름, 국영수 점수를 넣으면
        // == 성적표 ==
        // 이름: 유민
        // 국어: 90
        // 영어: 87
        // 수학: 79
        // 평균:
        // 등급 : B
        // ==========
        // 위와 같이 콘솔창에 성적표가 출력되도록 한다.
        // 평균이 90점 이상이면 A, 80점 이상이면 B, 그 외 C

        makeCard("유민", 90, 87, 79);

        System.out.println("\n=========================================================\n");

        // LoofWhile 에서 포켓몬 했던거를 메소드로 묶어서 실행

//        playPokemon();

        System.out.println("\n=========================================================\n");

        // 팩토리얼을 메소드화
        // 팩토리얼을 했었는데.. 어떤파일에서 했더라??
        // [ Ctrl Shift F ]

        System.out.println(factorial(5));

        // 재귀함수
        // 메소드 내에서 해당 메소드를 실행하는 케이스

        // 콘솔창에 1부터 n까지 출력하는 메소드
        printNum(10);

        // 재귀함수 방식
        recPrintNum(10);

        System.out.println(recFactorial(5));








    }   // main 메소드 끝

    public static long recFactorial(int num){
        // 재귀함수로 팩토리얼 메소드 구현하기
        if(num == 1){
            return 1;
        }
        // num 5가 들어오면
        return num * recFactorial(num - 1);
        // return 5 * recFactorial (4)
        // return 5 * 4 * recFactorial (3)
        // return 5 * 4 * 3 * recFactorial (2)
        // return 5 * 4 * 3 * 2 * recFactorial (1)
        // return 5 * 4 * 3 * 2 * 1




    }


    public static void recPrintNum(int num){
        System.out.println(num); // 10
        // 자기자신을 호출 (= 재귀함수) -> 함수내에서 같은함수 사용
        // 무한 반복 실행을 주의
        if(num == 1){
            // 더이상 실행 안함
            return; // 메소드 즉시 종료
        }

        recPrintNum(num - 1); // 파라미터에 9
    }


    public static void printNum(int num){
        for(int i = 1; i <= num; i++){
            System.out.println(i);
        }
    }

    public static long factorial(int n){
        long num = n;
        for(int i = 1; i <= n; i++){
            num = i * num;
        }
        return num;
    }

    public static void playPokemon(){
        Scanner scan = new Scanner(System.in);

        int hp = 100;
        // 이 while문의 이름이 outer가 됨
        outer:while(true){
            System.out.println("야생의 피카츄를 만났습니다.");
            System.out.println("행동을 선택해주세요");
            System.out.println("1. 공격 | 2. 도망");
            System.out.println(">>> ");

            int command = Integer.parseInt(scan.nextLine());

            if(command == 1){
                // TODO 공격
                while(true){
                    System.out.println("공격 방법 선택");
                    System.out.println("1. 몸통박치기 | 2. 하이드로펌프 | 3. 취소");
                    System.out.println(">>>");

                    int attack = Integer.parseInt(scan.nextLine());

                    if(attack == 1){
                        System.out.println("몸통 박치기 시전");
                        hp -= 20;
                    }else if(attack == 2){
                        System.out.println("하이드로펌프 시전");
                        hp -= 40;
                    }else if(attack == 3){
                        // 취소
                        // 가까운 반복문 1개 즉시 종료
                        // 내부 while만 종료된다.
                        break;
                    }

                    if(hp <= 0){
                        System.out.println("피카츄를 잡았다~!!");
                        // 외부 while문을 종료 시키려면??
                        // System.exit(0); // 프로그램 종료
                        // 외부 while문에 네임태그 설정
                        // break outer; // 해당 이름을 가진 while문 종료
                        // 리턴타입이 void 이더라도 return은 사용이 가능하다.
                        //메소드 내에서 return이 실행되면 해당 메소드는 즉시 종료된다.
                        return;
                    }

                }
            }else if(command == 2) {
                System.out.println("메다닥 도망갔습니다.");
                break;
            }else{
                System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    public static void print(String word){
        System.out.println(word);
    }

    // 기본적으로 변수와 같이 메소드명은 중복 선언할 수 없다.
    // 하지만 하나의 클래스 내에서 이름이 같은 메소드명을
    // 파라미터가 다르게 선언하면 중복 선언할 수 있다.
    // => 메소드 오버로딩(Method Overloading)
    public static void print(int word){
        System.out.println(word);
    }

    public static void print(double word){
        System.out.println(word);
    }

    public  static int myAbs(int number){
        if(number < 0){
            // number가 음수일때만 실행
            // 음수인 num을 양수로 바꿔주기
            // 음수에 -1을 곱하면 양수가 된다.
            number *= -1;
        }
        return number;
    }



    // 메소드의 선언
    // public : 접근 제어자
    // static : 정적 메소드를 선언
    // void : 함수의 리턴값이 없음을 의미 (리턴값이 있으면 이 자리에 리턴값의 타입을 적어준다)
    // printSum은 함수명을 의미(선언한 메소드를 실행 시 함수명을 이용)
    // 소괄호 ()안에는 입력받을 파라미터를 선언
    public static void printSum(int startNumber, int endNumber){
        int sum = 0;
        // 메소드가 실행될때 a, b 값을 받아야 한다. => 파라미터에 기입
        for(int i = startNumber; i <= endNumber; i++){
            sum += i;
        }
        System.out.println(startNumber + "부터" + endNumber + "까지 더한 결과: " + sum);
    }

    public static int returnSum(int startNumber, int endNumber){
        int sum = 0;
        for(int i = startNumber; i <= endNumber; i++){
            sum += i;
        }
        // sum값을 리턴
        return sum;

    }


    /**
     * 입력한 소수를 소수 n번째 자리로 반올림하여 리턴해주는 함수
     * @param num 반올림하고자 하는 소수
     * @param n 소수 n번째 자리를 지정하는 정수
     * @return 반올림 된 소수 리턴
     */
    public  static double myRound(double num, int n){
        // Math.round() 은 소수 첫째자리에서 반올림한 정수 리턴
        // 3.141592
        // Math.round(3/141592) => 3 리턴

        // 3.141592 에 10을 곱함(10의 1승) => 31.41592
        // Math.round(31.41592) => 31 리턴
        // 리턴값에 10을 나눔(10의 1승) => 3.1

        // 3.141592 에 100을 곱함(10의 2승) => 314.1592
        // Math.round(314.1592) => 314 리턴
        // 리턴값에 100을 나눔(10의 2승) = 3.14

        // num 에 10^n 곱한 후 Math.round()를 적용한 값에
        // 10^n 나누기
        int random = 1;
        for(int i = 0; i < n; i++){
            random *= 10;
        }
        return (double)(Math.round(num * random)) / random;

    }






    // makeCard 에 정수, 소수, 문자 모두 들어갈 수 있어야함.
    // 90이상 A 80 이상 B 그 외 C

    public static void makeCard(String name, int kor, int eng, int math){
        System.out.println("이름: " + name );
        System.out.println("국어: " + kor);
        System.out.println("영어: " + eng);
        System.out.println("수학: " + math);
        double avg = (double)(kor + eng + math) / 3;
        // avg를 소수 셋째자리에서 반올림하여 소수 둘째자리로 만들기
        // math.round() 는 소수 첫째자리에서 반올림한 정수값을 리턴
        // 우리만의 반올림 메소드 myRound()를 만들어보자 !
        avg = myRound(avg, 2);

        System.out.println("평균: " + avg);
        String deg = "C";
        if(avg >= 90){
           deg = "A";
        }
        else if(avg >= 80){
           deg = "B";
        }
        System.out.println("등급: " + deg);
    }














}
