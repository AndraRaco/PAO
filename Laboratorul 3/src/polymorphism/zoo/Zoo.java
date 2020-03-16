package polymorphism.zoo;

public class Zoo
{
    private final int nrMaxAnimale; // putem initializa la declare, in constructor si in blocuri
    private int indexCurent;
    //blocuri:
    //static{} - bloc static
    //{ nrMaxAnimale = 5; } - bloc nestatic

    Animal[] animaleZoo;

    public Zoo(int nrMaxAnimale) {
        this.nrMaxAnimale = nrMaxAnimale;
        this.animaleZoo = new Animal[nrMaxAnimale];
    }

    public void adaugAnimal(Animal animal)
    {
        if(indexCurent < animaleZoo.length)
        {
            animaleZoo[indexCurent] = animal;
            indexCurent++;
            System.out.println("Adaugat animal " + animal.getClass());
        }
    }


}
