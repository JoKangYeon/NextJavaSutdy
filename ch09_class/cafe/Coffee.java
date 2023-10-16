package ch09_class.cafe;

public class Coffee {
    private String name;    /* 음료수 명 */
    private int price;      /* 음료 가격 */

    public Coffee(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Coffee() {
    }

    @Override
    public String toString() {
        return "Coffee[" +
                 name +
                ", 가격:" + price +
                ']';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}

