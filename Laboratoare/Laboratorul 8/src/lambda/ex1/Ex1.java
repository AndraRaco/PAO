package lambda.ex1;

public class Ex1 {
    public static void main(String[] args) {
        Instrument guitar = new Guitar();
        guitar.play();

        Instrument piano=new Instrument() { // Implementare clasa anonima
            @Override
            public void play() {
                System.out.println("Playing piano");
            }
        };
        piano.play();

        // Expresie lambda
        Instrument i1=()-> System.out.println("new instrument playing"); // O implementare pentru functia play din interfata
        i1.play();

        Instrument i2=()-> System.out.println("stop playing"); // O implementare pentru functia play din interfata
        i2.play();
    }
}
