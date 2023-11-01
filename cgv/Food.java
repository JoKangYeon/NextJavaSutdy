package cgv;

public class Food {
    private String name;
    private int price;
    private String size;

    public Food() {
    }

    public Food(String name, int price, String size) {
        this.name = name;
        this.price = price;
        this.size = size;
    }

    @Override
    public String toString() {
        return "[" + name + ", " + price + "원, " + size + "]";
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
