package ch13_thread.issac;

public class IssacMain {

    public static void main(String[] args) {
        Chef chef = new Chef();

        // 콜백함수 구현
        chef.endCook = new EndCook() {
            @Override
            public void theEnd() {
                System.out.println("요리 끝");
            }
        };

        // 람다식 사용
        chef.endCook = () -> {
            System.out.println("요리 끝");
        };

        // 언제 20개를 다 만들지 확실하게 알 수 없다.
        chef.start();

        // 끝난 타이밍은 안다.
        // 끝났을 때 실행시킬 함수를 만들어서 쓸 수 있다.
        // = 콜백 함수
        // 콜백함수 정의를 실행단에서 함

        Customer gangyeon = new Customer(2);
        Customer yumin = new Customer(1);
        Customer taegon = new Customer(3);

        gangyeon.start();
        yumin.start();
        taegon.start();















    }
}
