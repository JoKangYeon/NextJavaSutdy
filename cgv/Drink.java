package cgv;

public class Drink {
    private String name;
    private int price;
    private boolean sugar;

    public Drink() {

    }

    public Drink(String name, int price, boolean sugar) {
        this.name = name;
        this.price = price;
        this.sugar = sugar;
    }

    @Override
    public String toString() {
        String state = "[" + name + ", " + price + "원, 설탕x]";
        if(sugar){
            state = "[" + name + ", " + price + ",원 설탕o]";
        }
        return state;
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

    public boolean isSugar() {
        return sugar;
    }

    public void setSugar(boolean sugar) {
        this.sugar = sugar;
    }

}
