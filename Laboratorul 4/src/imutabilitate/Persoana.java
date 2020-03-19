package imutabilitate;

// Daca folosim final, inseamna ca nu mai poata fi mostenita

//Imutabil daca am final si la declararea clasei si la paramentrii
// Trebuie sa lucram cu copie a referintelor primite ca parametru, altfel mai putem modifica elemente

public final class Persoana { // Imutabil
    private final int id;
    private final String nume;
    private final Adresa adresa;

    public Persoana(int id, String nume, Adresa adresa) {
        this.id = id;
        this.nume = nume;

//        String numeStrada = adresa.getStrada();
//        String numarStrada = adresa.getNumar();
//        Adresa copieAdresa = new Adresa(numeStrada, numarStrada);
//        this.adresa = copieAdresa;

        this.adresa=new Adresa(adresa);
    }

    public Adresa getAdresa() {
        String numeStrada=adresa.getStrada();
        String numarStrada=adresa.getNumar();
        Adresa copieAdresa=new Adresa(numeStrada,numarStrada);
        return copieAdresa;
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", adresa=" + adresa +
                '}';
    }
}
