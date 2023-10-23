package ch10_extends_interface.simple;

public class Parent {
    String name;
    int age;

    public Parent() {
    }

    public Parent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void hello(){
        System.out.println("어른인 " + name + "입니다.");
    }






    // Override는 부모의 메소드를 자식 클래스에서 재정의(수정)
    // 하는 것을 의미한다.
    // 모든 클래스는 기본적으로 보이지는 않지만 Object 클래스를
    // 상속받고 있다.
    // toString 메소드는 Object 클래스에 정의되어 있는 메소드
    @Override
    public String toString() {
        return "Parent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
