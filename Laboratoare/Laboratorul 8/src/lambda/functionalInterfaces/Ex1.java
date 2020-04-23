package lambda.functionalInterfaces;

import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Consumer<T> - void accept(T t)
 * BiConsumer<T,R> - void accept(T t, R r)
 * Supplier<T> - T get()
 * Function<T, R> - R apply(T t)
 * Predicate<T> - boolean test(T t)
 */

public class Ex1 {
    public static void main(String[] args) {
        Consumer<String> c1 = x -> System.out.println(x);
        c1.accept("abc");

        Supplier<LocalDate> ld=()->LocalDate.now();
        System.out.println(ld.get());

        Function<String, Integer> f1=s->s.length();
        System.out.println(f1.apply("sadfgfhgds"));

        Predicate<Integer> p1=x->x%2==0;
        System.out.println(p1.test(2));
    }
}
