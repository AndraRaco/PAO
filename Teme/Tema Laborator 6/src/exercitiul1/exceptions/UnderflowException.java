package exercitiul1.exceptions;

public class UnderflowException extends IllegalArgumentException {
    public UnderflowException() {
        super();
        System.out.println("The double variable exceeds the Double limit, too small.");
    }

    public UnderflowException(String message) {
        super(message);
    }
}
