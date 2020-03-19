package asociere;

import java.util.Arrays;

public class Departament { // has-a
    private String nume;
    private Profesor[] profesori; // profesorii pot exista si far departament

    public Departament(String nume) {
        this.nume = nume;
    }

    public Profesor[] getProfesori() {
        return profesori;
    }

    public void setProfesori(Profesor[] profesori) {
        this.profesori = profesori;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString() {
        return "Departament{" +
                "nume='" + nume + '\'' +
                ", profesori=" + Arrays.toString(profesori) +
                '}';
    }
}
