package lambda.ex1;

/**
 * functional interface = interfete care au doar o metoda abstracta,
 * pot fi oricate metode default sau statice
 */
public interface Instrument { // Functional interface
    void play();

    default void clean(){
        System.out.println("in default method");
    }

    static void inStatic(){
        System.out.println("static");
    }
}
