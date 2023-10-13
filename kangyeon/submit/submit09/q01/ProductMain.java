package kangyeon.submit.submit09.q01;

import java.util.ArrayList;

public class ProductMain {
    public static void main(String[] args) {

        Product ref = new Product("냉장고", 2000000);
        Product tv = new Product("TV", 1000000);
        Product air = new Product("에어컨", 800000);
        Product cpt = new Product("컴퓨터", 1300000);
        Product wind = new Product("선풍기", 100000);

        System.out.println(ref);

        ArrayList<Product> prodArray = new ArrayList<>();

        prodArray.add(ref);
        prodArray.add(tv);
        prodArray.add(air);
        prodArray.add(cpt);
        prodArray.add(wind);

        for(int i = 0; i < prodArray.size() - 1; i++){
            for(int k= 0; k < prodArray.size() - 1; k++){

            }
        }

















    }


}
