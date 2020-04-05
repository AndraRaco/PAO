public class VirtualCoffee {
    public static void prepareCup(Cup cup) {
        cup.wash();
    }

    //static polymorphism
    //dynamic polymorphism
    public static void main(String[] args) {

        Cup cup = new Cup();
        prepareCup(cup);

        Cup cofeeCup = new CoffeeCup();
        prepareCup(cofeeCup);

        //dynamic polymorphism
        Cup teaCup = new TeaCup();
        prepareCup(teaCup);
    }
}
