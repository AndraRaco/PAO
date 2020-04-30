package optional;

import java.util.Optional;

public class Ex2 {
    public static void main(String[] args) {
        String initialValue = "123";
        Ex2 ex2 = new Ex2();
        System.out.println("using orElse");
        String s1 = Optional.ofNullable(initialValue).orElse(ex2.getDefault());
        System.out.println(s1);

        System.out.println("using orElseGet");
        String s2 = Optional.ofNullable(initialValue).orElseGet(ex2::getDefault);
        System.out.println(s2);

        String s3 = null;
        String s4 = Optional.ofNullable(s3).orElseThrow(IllegalArgumentException::new);
    }

    String getDefault() {
        System.out.println("getting default value");
        return "default";
    }
}
