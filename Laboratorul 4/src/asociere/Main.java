package asociere;

public class Main {
    public static void main(String[] args) {
        Profesor profesorPrincipalMate = new Profesor(1, "Popescu");
        Profesor profesorSecundarMate = new Profesor(2, "Ionescu");

        Profesor profesorInfo = new Profesor(3, "Anghel");
        Profesor profesorMateInfo = new Profesor(4, "Petrescu");
        Profesor profesorInfoMate = new Profesor(5, "Andrei");

        Departament departamentInfo = new Departament("info");
        departamentInfo.setProfesori(new Profesor[]{profesorInfo, profesorInfoMate, profesorMateInfo});

        Departament departamentMate = new Departament("mate");
        departamentMate.setProfesori(new Profesor[]{profesorInfoMate, profesorMateInfo, profesorPrincipalMate, profesorSecundarMate});

        Universitate unibuc = new Universitate("UNIBUC", new Departament[]{departamentInfo, departamentMate});

        System.out.println(unibuc);
        departamentInfo = null; // folosim Arrays.copyOf din cauza asta atunci cand ob
        //referentiate de acest paramentru nu vor ajunge null, pentru ca folosim o copie
        System.out.println(unibuc);

//        System.out.println(departamentMate);
//        departamentMate = null; // Curatat din memeorie
//        System.out.println(departamentMate);

        System.out.println(departamentMate);
        departamentMate.getProfesori()[1]=null;
        System.out.println(departamentMate);
        System.out.println(profesorSecundarMate);


    }
}
