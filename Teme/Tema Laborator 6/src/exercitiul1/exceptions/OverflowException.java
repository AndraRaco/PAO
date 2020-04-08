package exercitiul1.exceptions;

public class OverflowException extends IllegalArgumentException {
    public OverflowException() {
        super();
        System.out.println("The double variable exceeds the Double limit, too big.");
    }

    public OverflowException(String message) {
        super(message);
    }
}
