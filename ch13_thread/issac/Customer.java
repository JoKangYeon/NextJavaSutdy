package ch13_thread.issac;

public class Customer extends Thread{

    private int count;

    public Customer(int count){
        this.count = count;
    }

    @Override
    public void run() {
        Issac issac = Issac.getInstance();
        issac. buyToast(count);

    }
}
