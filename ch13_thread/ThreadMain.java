package ch13_thread;

public class ThreadMain {

    public static void main(String[] args) {
        // 20부터 25까지 차례대로 출력
//        printNum(20);

        // 100부터 105까지 차례대로 출력
//        printNum(100);

        // 기본적으로 멀티스레드를 구현하지 않으면
        // 메인 스레드 하나만 일을 하므로
        // 위에서부터 차례대로 코드가 실행된다(=동기)

        // 1. Thread 를 상속받은 클래스를 이용하여 멀티 스레드 구현
        ExThread exTh = new ExThread(100);
        // 메인 스레드가 아닌 다른 스레드에게 ExThread 내 run 메소드 실행 시킴
        exTh.start();   // 비동기

        ExThread exTh2 =new ExThread(200);
        exTh2.start();

//        printNum(20);   // 메인 스레드가 실행

        // 외부 스레드에 일을 던지는 비동기 코드의 경우
        // 각각의 외부 스레드가 언제 일이 끝날지 모른다.

        // 2. Runnable 인터페이스를 구현(implement)한 클래스를 이용

        ExRunnable exRun = new ExRunnable(300);
        Thread th = new Thread(exRun);
        th.start();

        // 3. 람다식 사용 (클래스 파일을 따로 만들 필요없음)
        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
               printNum(400);
            }
        });
        th2.start();

        Thread th3 = new Thread( () -> {
           printNum(500);
        } );
        th3.start();























































    }   // 메인 끝

    public static void printNum(int n){
        for(int i = n; i <= n + 5; i++){
            System.out.println(i);

            try {
                // 실행에 텀을 주고 싶을 때 사용
                // slepp() 안에 숫자는 밀리초
                // 이 코드를 실행한 Thread 만 잠에 든다.
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
