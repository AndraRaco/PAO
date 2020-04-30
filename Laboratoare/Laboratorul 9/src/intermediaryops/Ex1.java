package intermediaryops;

import java.sql.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex1 {
    public static void main(String[] args) {
        // limit, filter, skip, distinct, sorted, peek, map, flatmap

        // skip
        System.out.println("skip");
        IntStream is1 = IntStream.rangeClosed(1, 10).skip(7); // 8 9 10
        is1.forEach(System.out::println);

        // distinct
        System.out.println("distinct");
        List<Integer> integers = Arrays.asList(1, 1, 4, 1, 2, 2, 3, 3);
        integers.stream().distinct().forEach(System.out::println);

        // sorted
        System.out.println("sorted");
        integers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
