package exercitiul1.exceptions;

public class NullParameterException extends NullPointerException {
    public NullParameterException() {
        super();
        System.out.println("One of the parameters of th method is null.");
    }

    public NullParameterException(String message) {
        super(message);
    }
}
