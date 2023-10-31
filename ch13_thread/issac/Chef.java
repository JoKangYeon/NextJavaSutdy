package ch13_thread.issac;

public class Chef extends Thread{

    // 1, 콜백 함수용 추상 메소드를 가진 인터페이스 생성
    public EndCook endCook;

    @Override
    public void run() {
        // 1초마다 토스트 생산
        Issac issac = Issac.getInstance();

        for(int i = 0; i < 20; i++){
         issac.makeToast();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // 생산 끝
        endCook.theEnd(); // <- 추상 메소드 상태
    }
}
