package ch10_extends_interface.lol;

// 인터페이스는 implements 를 이용하여 구현한다.
public class Yasuo implements Skill{
    String name;
    int damage;
    int hp;


    @Override
    public void skillQ() {
        System.out.println("칼로 찌르기");
    }

    @Override
    public void skillW() {
        System.out.println("바람의 장막");
    }

    @Override
    public void skillE() {
        System.out.println("돌진");
    }

    @Override
    public void skillR() {
        System.out.println("난도질");
    }
}
