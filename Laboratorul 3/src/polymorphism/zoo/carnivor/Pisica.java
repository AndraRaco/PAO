package polymorphism.zoo.carnivor;

public class Pisica extends Carnivor
{
    public Pisica(String nume, int varsta) {
        super(nume, varsta);
        this.sunet_specific = "miauna";
    }

    @Override
    public void scoateSunet() {
        System.out.println("pisica " + this.sunet_specific);
    }
}
