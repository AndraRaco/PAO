package optional;

import java.util.Optional;
import java.util.stream.Stream;

public class Ex1 {
    public static void main(String[] args) {
        Optional<String> empty = Optional.empty(); // Creates an empty object
        System.out.println(empty.isPresent());

        Optional<String> o1 = Optional.of("aabbcd");
        System.out.println(o1.isPresent());
        System.out.println(o1.isEmpty());

        String s1 = null;
        Optional<String> nullSafe = Optional.ofNullable(s1);
        System.out.println(nullSafe);

        String s2 = Optional.ofNullable(s1).orElse("123");
        System.out.println(s2);

        String s3 = Optional.ofNullable(s1).orElseGet(() -> "555");
        System.out.println(s3);

    }
}
