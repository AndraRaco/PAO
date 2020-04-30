package streamsource;

import java.util.*;
import java.util.stream.Stream;

public class Ex1 {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 4, 6, 7, 9, 22, 23, 44);

        // Var 1 using iteration
        System.out.println("using iteration");
        for (int i : intList) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
        System.out.println();

        // Var 2 using stream()
        System.out.println("using stream");
        intList.stream()
                .filter(i -> i % 2 == 0)
                .forEach(System.out::println); // or .forEach(System.out.println(i);
        System.out.println();

        // empty()
        System.out.println("using empty");
        long count=streamOf(new HashSet<>()).count(); // count return long
        System.out.println(count);

        // builder()
        System.out.println("using builder");
        Stream<String> streamWithBuilder = Stream.<String>builder().add("aa").add("aab").add("aabc").add("bc").build();
        streamWithBuilder.filter(s->s.startsWith("a"))
                .max(Comparator.comparingInt(String::length));
        System.out.println(streamWithBuilder);
        // CRED CA TREBUIE SA MAI ADD CEVA PE AICI
    }

    public static Stream<String> streamOf(Set<String> set){
        return set==null || set.isEmpty() ? Stream.empty(): set.stream();
    }

}
