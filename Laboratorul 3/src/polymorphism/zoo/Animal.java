package polymorphism.zoo;

public abstract class Animal{
    private int nrIdentificare;
    private String nume;
    private int varsta;
    protected String tip_hrana;
    protected String sunet_specific;

    public Animal(String nume, int varsta)
    {
        this.nrIdentificare=hashCode(); //Generat o succesiune de cifre(int) la crearea fiecarui obiect
        this.nume = nume;
        this.varsta = varsta;
    }

    public abstract void seHraneste();

    public abstract void scoateSunet();

    public void afisareDetalii()
    {
        System.out.println("Acesta este " + this.toString());
    }
}
