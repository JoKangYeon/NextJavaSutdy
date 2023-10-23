package ch10_extends_interface.ramen;

// 추상 메소드를 하나라도 가지고 있는 클래스는
// abstract를 붙여서 추상클래스로 만들어주어야 한다.
public abstract class Ramen {
    private String name;
    private int price;
    private String company;

    public Ramen() {
    }

    public Ramen(String name, int price, String company) {
        this.name = name;
        this.price = price;
        this.company = company;
    }

    // Ramen을 상속받는 객체들마다 printRecipe 메소드가
    // 존재하지만 내부 실행코드는 조금 다를 경우
    // -> 추상메소드
    public abstract void printRecipe();


    @Override
    public String toString() {
        return "Ramen{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", company='" + company + '\'' +
                '}';
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
