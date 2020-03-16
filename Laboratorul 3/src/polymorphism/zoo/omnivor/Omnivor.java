package polymorphism.zoo.omnivor;

import polymorphism.zoo.Animal;

public abstract class Omnivor extends Animal
{
    public Omnivor(String nume, int varsta) {
        super(nume, varsta);
        tip_hrana = "carne si vegetatie";
    }

    @Override
    public void seHraneste() {
        System.out.println(this + " se hraneste cu " + this.tip_hrana);
    }
}
