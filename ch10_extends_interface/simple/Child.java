package ch10_extends_interface.simple;

// Child는 Parent를 상속받는 클래스다.
// = 클래스 이름옆에 extends Parent 을 작성해준다.
public class Child extends Parent{


    public Child() {
    }

    public Child(String name, int age) {
        // super 는 부모 객체를 의미
        // super() 는 부모의 생성자를 의미
        super(name, age);
    }

    // 부모가 가진 메소드를 자식 클래스에서 재정의
    // = Override

    @Override
    public void hello() {
//        super.hello(); // 부모의 hello 메소드가 실행
        System.out.println("아이인 " + name + "입니다.");
    }
}
