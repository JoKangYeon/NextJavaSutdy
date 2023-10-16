package kangyeon.submit.submit09.q01;

// lombok 라이브러리를 설치한다면? -> 아래문구를 입력하면 자동으로 되긴함
//@Constructor
//@getter
//@setter

public class Product {

    String prodName;    // 제품명
    int prodPrice;      // 제품 가격


    @Override
    public String toString() {
        return "Product[" + "name=" + prodName + ", "
                + "price=" + prodPrice + ']';
    }


    Product(String prodName, int prodPrice) {
        this.prodName = prodName;
        this.prodPrice = prodPrice;
    }

    Product(){

    }
}
