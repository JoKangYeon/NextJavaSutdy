package ch10_extends_interface.ramen;

public class Neoguri extends Ramen{

    public Neoguri() {
    }

    public Neoguri(String name, int price, String company) {
        super(name, price, company);
    }

    @Override
    public void printRecipe(){
        System.out.println("끓는 물에 다시마와 스프, 면을 넣고 4분동안 익힌 후 드셔요");
    }


}
