package polymorphism.zoo.carnivor;

public class Leu extends Carnivor
{
    public Leu(String nume, int varsta) {
        super(nume, varsta);
        this.sunet_specific = "rage";
    }

    @Override
    public void scoateSunet() {
        System.out.println("leul " + this.sunet_specific);
    }

    @Override
    public String toString() {
        return super.toString() + "Leu{" +
                "sunet_specific='" + sunet_specific + '\'' +
                '}';
    }
}

