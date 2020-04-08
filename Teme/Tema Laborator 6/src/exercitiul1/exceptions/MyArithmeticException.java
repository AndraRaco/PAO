package exercitiul1.exceptions;

public class MyArithmeticException extends ArithmeticException {
    public MyArithmeticException() {
        super();
        System.out.println("Division to 0 is not allowed.");
    }

    public MyArithmeticException(String message) {
        super(message);
    }
}
