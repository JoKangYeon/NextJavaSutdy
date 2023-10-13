package kangyeon.submit.submit09.q01;

public class Product {

    private static String prodName;
    private static int prodPrice;


    @Override
    public String toString() {
        return "name=" + prodName + ", "
                + "price=" + prodPrice;
    }


    public Product(String prodName, int prodPrice) {
        this.prodName = prodName;
        this.prodPrice = prodPrice;
    }

    public static String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public static int getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(int prodPrice) {
        this.prodPrice = prodPrice;
    }
}
