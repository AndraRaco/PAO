package exceptions.ex3;

public class Ex3 {
    public static void main(String[] args) {
        try (R2 r1 = new R2("r1");
             R2 r2 = new R2("r2")) {
            System.out.println("in try block");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("finally");
        }
    }
}
