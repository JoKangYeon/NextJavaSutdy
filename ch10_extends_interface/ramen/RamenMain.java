package ch10_extends_interface.ramen;

public class RamenMain {

    public static void main(String[] args) {

        Neoguri neoguri = new Neoguri("너구리", 900, "농심");

        neoguri.printRecipe();

        Mupama mupama = new Mupama("무파마", 1200, "농심");

        System.out.println(mupama);
        mupama.printRecipe();



























    }
}
