package polymorphism.zoo.omnivor;

public class Urs extends Omnivor
{
    public Urs(String nume, int varsta) {
        super(nume, varsta);
        this.sunet_specific = "mormaie";
    }

    @Override
    public void scoateSunet() {
        System.out.println("urs " + this.sunet_specific);
    }
}
