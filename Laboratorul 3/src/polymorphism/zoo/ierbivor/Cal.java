package polymorphism.zoo.ierbivor;

public class Cal extends Ierbivor
{
    public Cal(String nume, int varsta) {
        super(nume, varsta);
        this.sunet_specific = "necheza";
    }

    @Override
    public void scoateSunet() {
        System.out.println("cal " + this.sunet_specific);
    }
}
