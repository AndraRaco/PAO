package lambda.ex2;

public class Ex1 {
    public static void main(String[] args) {
        I1 i1 = (x1, x2) -> x1 + x2;
        System.out.println(i1.add(2, 3));

        I2 i2 = x -> x * 10;
        System.out.println(i2.multiplyByTen(11));
    }
}
