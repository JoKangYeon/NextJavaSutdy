package kangyeon.submit.submit09.q02;

import ch09_class.common.UtilClass;

import java.util.ArrayList;
import java.util.Scanner;

public class FishingMain {

    public static void main(String[] args) {

        ArrayList<Fish> fishList = new ArrayList<>();

        Fish mackerelFish = new Fish("고등어", 5000);
        Fish flatFish = new Fish("광어", 25000);
        Fish rockFish = new Fish("우럭", 27000);
        Fish redseaFish = new Fish("참돔", 30000);
        Fish seabreamFish = new Fish("돌돔", 35000);
        Fish highFish = new Fish("능성어", 70000);
        Fish deepFish = new Fish("다금바리", 120000);

        fishList.add(mackerelFish);
        fishList.add(flatFish);
        fishList.add(rockFish);
        fishList.add(redseaFish);
        fishList.add(seabreamFish);
        fishList.add(highFish);
        fishList.add(deepFish);

        // fishList 내부 확인
        /*for(int i = 0; i < fishList.size(); i++){
            System.out.println(fishList.get(i));
        }*/

        Scanner scan = new Scanner(System.in);

        // 잡은 물고기를 담을 가방
        ArrayList<Fish> fishBag = new ArrayList<>();

        // 낚시하기 선택시
        // 다금바리 5% 확률
        // 능성어 10% 확률
        // 돌돔 12% 확률
        // 참동 13% 확률
        // 우럭 15%
        // 광어 15%
        // 고등어 30% 로 잡히도록 코드 수정


        // 5% 확률로 낚시대가 뿌셔질 수 있음
        // 낚시대가 뿌셔지면 더 이상 낚시하기 불가능



        // 낚시대의 상태
        boolean isBroken = false;

        // 미끼의 개수
        int count = 10; // 낚시를 할 때마다 미끼가 1개씩 줄고 미끼가 0개면 낚시 불가능

        while(true) {
            System.out.println("행동을 선택해주세요.");
            System.out.println("1. 낚시하기 | 2. 잡은 물고기 목록 | 3. 떠나기");
            System.out.print(">>> ");

            int select = Integer.parseInt(scan.nextLine());
            // 랜던 물고기 추출
            int fishNum = (int)(Math.random() * fishList.size());
            int sumPrice = 0; // 총 물고기가치 변수 선언
            // 1~100 랜덤 정수 생성 (= 물고기 낚을 확률)
            int rand = (int)(Math.random() * 100 + 1);
            int randNum = UtilClass.makeRandom(1, 100);

            if(select == 1) {

                if(isBroken){
                    System.out.println("낚시대가 부러져 더 이상 낚시가 불가능합니다.");
                    continue;
                }
                // TODO 낚시하기
                if(randNum <= 5){
                    // 낚시대가 부서짐
                    System.out.println("낚시대 박살..");
                    // 낚시대가 부러진 상태를 저장
                    isBroken = true;
                    continue;
                }

                if(count == 0){
                    // 미끼를 모두 사용
                    System.out.println("미끼가 없어서 더 이상 낚시가 불가능합니다.");
                    continue;
                }

                if(rand <= 30){
                    System.out.println(fishList.get(0).fishName + "을 잡았다!!");
                    System.out.println("미끼가 " + (count - 1) + "개 남았습니다.");
                    fishBag.add(fishList.get(fishNum)); // 잡은 물고기 가방에 넣기
                    count--;
                }else if(rand <= 45){
                    System.out.println(fishList.get(1).fishName + "을 잡았다!!");
                    System.out.println("미끼가 " + (count - 1) + "개 남았습니다.");
                    fishBag.add(fishList.get(fishNum)); // 잡은 물고기 가방에 넣기
                    count--;
                }else if(rand <= 60){
                    System.out.println(fishList.get(2).fishName + "을 잡았다!!");
                    System.out.println("미끼가 " + (count - 1) + "개 남았습니다.");
                    fishBag.add(fishList.get(fishNum)); // 잡은 물고기 가방에 넣기
                    count--;
                }else if(rand <= 73){
                    System.out.println(fishList.get(3).fishName + "을 잡았다!!");
                    System.out.println("미끼가 " + (count - 1) + "개 남았습니다.");
                    fishBag.add(fishList.get(fishNum)); // 잡은 물고기 가방에 넣기
                    count--;
                }else if(rand <= 85){
                    System.out.println(fishList.get(4).fishName + "을 잡았다!!");
                    System.out.println("미끼가 " + (count - 1) + "개 남았습니다.");
                    fishBag.add(fishList.get(fishNum)); // 잡은 물고기 가방에 넣기
                    count--;
                }else if(rand <= 95){
                    System.out.println(fishList.get(5).fishName + "을 잡았다!!");
                    System.out.println("미끼가 " + (count - 1) + "개 남았습니다.");
                    fishBag.add(fishList.get(fishNum)); // 잡은 물고기 가방에 넣기
                    count--;
                }else if(rand <= 100){
                    System.out.println(fishList.get(6).fishName + "을 잡았다!!");
                    System.out.println("미끼가 " + (count - 1) + "개 남았습니다.");
                    fishBag.add(fishList.get(fishNum)); // 잡은 물고기 가방에 넣기
                    count--;
                }
            }else if(select == 2) {
                System.out.println("내 가방 ===============");
                for(int i = 0; i < fishBag.size(); i++){
                    System.out.println(fishBag.get(i));
                    sumPrice += fishBag.get(i).fishPrice;
                }
                System.out.println("총 " + sumPrice + "원 ==========");

                // TODO 잡은 물고기 목록 보기
            }else if(select == 3) {
                // TODO 종료
                System.out.println("잠시 후 종료됩니다.");
                break;
            }
        }
    }
}
