package ch10_extends_interface.ramen;

public class Mupama extends Ramen{
    private String name;
    private int price;
    private String company;

    public Mupama() {
    }

    public Mupama(String name, int price, String company) {
        super(name, price, company);
    }

    @Override
    public  void printRecipe(){
        System.out.println("끓는 물에 분말스프와 건더기 스프를 넣고 3분 후 잘 저어 드세요");
    }


}
