package ch10_extends_interface.starcraft;

import java.util.ArrayList;

public class StarcraftMain {

    public static void main(String[] args) {


        Marine marine = new Marine();

        System.out.println(marine);

        Marine marine2 = new Marine();

        System.out.println(marine2);

        marine.stimpack();

        System.out.println(marine);

        Zealot zealot = new Zealot();

        System.out.println(zealot);

        marine.move(10, 20);
        zealot.move(10, 20);

        marine.attack(zealot);

        System.out.println(zealot);

        HighTemplar highTemplar = new HighTemplar();

        highTemplar.psionicStorm();
        highTemplar.hallucination();

        marine.attack(highTemplar);

        System.out.println(highTemplar);

        Zealot zealot2 = new Zealot();
        Zealot zealot3 = new Zealot();
        Zealot zealot4 = new Zealot();
        Zealot zealot5 = new Zealot();
        Zealot zealot6 = new Zealot();

        // 테란 본진에 쳐들어가기
        zealot.move(100,150);
        zealot2.move(100,150);
        zealot3.move(100,150);

        // 질럿을 드래그해서 한번에 이동시키자
        ArrayList<Zealot> zealotList = new ArrayList<>();
        zealotList.add(zealot);
        zealotList.add(zealot2);
        zealotList.add(zealot3);
        zealotList.add(zealot4);
        zealotList.add(zealot5);
        zealotList.add(zealot6);

        for(int i = 0; i < zealotList.size(); i++){
            zealotList.get(i).move(100,150);
        }

        // ArrayList<Zealot> 에 HighTemplar를 담을 수 없다.
//        zealotList.add(highTemplar)

        // 다형성(Polymorphism)
        // 하나의 객체가 여러 타입을 가질 수 있는 것

        // 자식 객체에서 부모 객체로 형변환이 가능하다.
        StarUnit starZealot = zealot;   // Zealot -> StarUnit 자동 형변환

        // StarUnit을 담을 수 있는 리스트
        ArrayList<StarUnit> starList = new ArrayList<>();

        starList.add(zealot);   // Zealot -> StarUnit 자동 형변환 되며 담김
        starList.add(zealot2);
        starList.add(zealot3);
        starList.add(highTemplar);  // HighTemplar -> StarUnit 자동 형변환 되며

        for(int i = 0; i < starList.size(); i++){
            starList.get(i).move(200, 300);
        }

        // 마린의 attack에 다형성 적용
        marine.attack(zealot);
        marine.attack(highTemplar);

        System.out.println(zealot);
        System.out.println(highTemplar);

        //  .get(3)을 하면 StarUnit 타입이므로 자식 객체의 메소드 사용 불가
//        starList.get(3).psionicStrom();

        // HighTemplar -> StarUnit 을 다시
        // StarUnit -> HighTemplar롤 되돌려 준 후 메소드 사용 가능
        ((HighTemplar)starList.get(3)).psionicStorm();
        // Zealot -> StarUnit 이 된 객체를 HighTemplar로 형변환은 불가능
//        ((HighTemplar)starList.get(2)).psionicStorm();

        starList.add(marine);

        // 리스트 내 StarUnit이 원래 어떤 객체였는지 체크하기
        for (int i = 0; i < starList.size(); i++) {

            if (starList.get(i).getName().equals("하이템플러")) {
                ((HighTemplar) starList.get(i)).psionicStorm();
            }
            // 객체 instanceof 클래스
            // 좌측의 객체가 우측에 놓인 클래스로 형변환이 가능하다면
            // true, 가능하지 않으면 false를 리턴
            if (starList.get(i) instanceof HighTemplar) {
                ((HighTemplar) starList.get(i)).psionicStorm();
            }

            // instanceof를 이용하여 마린이면 스팀팩을 사용하도록 코드 작성
            if(starList.get(i) instanceof Marine){
                ((Marine)starList.get(i)).stimpack();
            }

        }

        // 부모 객체 생성
        StarUnit star = new StarUnit();

        // 일반적으로 부모객체는 자식 클래스로 형변환할 수 없다.
        System.out.println(star instanceof Zealot);
        System.out.println(star instanceof HighTemplar);

        // 자식 객체는 부모 클래스로 형변환이 가능하다.
        System.out.println(marine instanceof  StarUnit);
        System.out.println(highTemplar instanceof StarUnit);

        // 부모 클래스로 형변환 되었던 자식 객체는
        // 다시 자식 객체로 형변환이 가능하다.
        StarUnit temp = highTemplar;
        System.out.println(temp instanceof  HighTemplar);



















    }
}
