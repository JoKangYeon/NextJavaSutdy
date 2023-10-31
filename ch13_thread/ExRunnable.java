package ch13_thread;

// 1. Runnable 인터페이스 구현
public class ExRunnable implements Runnable{

   private int num;

   public ExRunnable(int num){
       this.num = num;
   }

    @Override
    public void run() {
        for(int i = num; i<= num+5; i++){
            System.out.println(i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
