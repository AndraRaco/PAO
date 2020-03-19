package imutabilitate;

public class Adresa {
    private String strada;
    private String numar;

    public Adresa(String strada, String numar) {
        this.strada = strada;
        this.numar = numar;
    }

    public Adresa(Adresa adresa) {
        this(adresa.getStrada(),adresa.getNumar());
    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public String getNumar() {
        return numar;
    }

    public void setNumar(String numar) {
        this.numar = numar;
    }

    @Override
    public String toString() {
        return "Adresa{" +
                "strada='" + strada + '\'' +
                ", numar='" + numar + '\'' +
                '}';
    }
}
