package kangyeon.submit.submit09.q01;

import java.util.ArrayList;
import java.util.Collections;

public class ProductMain {
    public static void main(String[] args) {

        Product abc = new Product();

        Product ref = new Product("냉장고", 2000000);
        Product tv = new Product("TV", 1000000);
        Product air = new Product("에어컨", 800000);
        Product cpt = new Product("컴퓨터", 1300000);
        Product wind = new Product("선풍기", 100000);

//        System.out.println(cpt);

        ArrayList<Product> prodArray = new ArrayList<Product>();

        prodArray.add(ref);
        prodArray.add(tv);
        prodArray.add(air);
        prodArray.add(cpt);
        prodArray.add(wind);

//        System.out.println(prodArray);


        // 일반 정렬
      /*  for(int i = 0; i < prodArray.size(); i++){
            System.out.println(prodArray.get(i));
        }*/

        // 가격별 오름차순 정렬
        // 버블정렬 사용
       /* for(int i = 0; i < prodArray.size() - 1; i++){
            for(int k= 0; k < prodArray.size() - 1; k++){
                if(prodArray.get(k).prodPrice > prodArray.get(k+1).prodPrice){
                    Product tmp = prodArray.get(k+1);
                    prodArray.set(k+1,prodArray.get(k));
                    prodArray.set(k, tmp);
                }
            }
        }*/

        Collections.sort(prodArray, (prodA, prodB) -> prodA.prodPrice - prodB.prodPrice);

        // 내림차순 정렬된 데이터 출력
        for(int i = 0; i < prodArray.size(); i++){
            System.out.println(prodArray.get(i));
        }

        // TV의 인덱스 번호 출력

        for(int i = 0; i < prodArray.size(); i++){
            if((prodArray.get(i).prodName).equals("TV")){
                System.out.println(i);
            }
        }

















    }


}
