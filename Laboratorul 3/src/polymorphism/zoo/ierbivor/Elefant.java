package polymorphism.zoo.ierbivor;

public class Elefant extends Ierbivor
{
    public Elefant(String nume, int varsta) {
        super(nume, varsta);
        this.sunet_specific = "trambiteze";
    }

    @Override
    public void scoateSunet() {
        System.out.println("leul " + this.sunet_specific);
    }
}
