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
        if (nrMaxAnimale > 0)
        {
            this.nrMaxAnimale = nrMaxAnimale;
            this.animaleZoo = new Animal[nrMaxAnimale];
        }
        else
        {
            throw  new RuntimeException("Nu ati introdus un nr intreg pozitiv");
        }
    }

    public void adaugAnimal(Animal animal)
    {
        if(indexCurent < animaleZoo.length)
        {
            animaleZoo[indexCurent] = animal;
            System.out.println("Adaugat animal " + animal.getClass() + indexCurent++);
        }
    }


}
