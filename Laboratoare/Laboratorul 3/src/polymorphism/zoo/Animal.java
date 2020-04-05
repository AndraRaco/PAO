package polymorphism.zoo;

public abstract class Animal // Nu putem avea final si abstract in acelasi timp
{
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

    @Override
    public String toString() {
        return "Animal din categoria " + this.getClass().getSuperclass().getSimpleName() +
                " din specia " + this.getClass().getSimpleName() + " {" +
                "nrIdentificare=" + nrIdentificare +
                ", nume='" + nume + '\'' +
                ", varsta=" + varsta +
                ", nrIdentificare=" + nrIdentificare +
                '}';
    }

    public String getNume()
    {
        return this.nume;
    }
}
