package polymorphism.zoo.ierbivor;

import polymorphism.zoo.Animal;

public abstract class Ierbivor extends Animal
{
    public Ierbivor(String nume, int varsta) {
        super(nume, varsta);
        this.tip_hrana = "vegetatie";
    }

    @Override
    public void seHraneste() {
        System.out.println(this + " se hraneste cu " + this.tip_hrana);
    }
}
