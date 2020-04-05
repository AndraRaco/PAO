package polymorphism.zoo.omnivor;

public class Caine extends Omnivor
{
    public Caine(String nume, int varsta) {
        super(nume, varsta);
        this.sunet_specific = "latrat";
    }

    @Override
    public void scoateSunet() {
        System.out.println("caine " + this.sunet_specific);
    }
}
