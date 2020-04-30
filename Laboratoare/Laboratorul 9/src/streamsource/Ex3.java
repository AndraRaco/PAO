package streamsource;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex3 {
    public static void main(String[] args) {
        IntStream streamOfChars = "abcdfgdfs".chars();
        streamOfChars.forEach(x -> System.out.println((char) x));

        Stream<String> streamOfStrings = Pattern.compile(",").splitAsStream("a,b,c,e,r,y");

        Path path = Paths.get("src\\streamsource\\Ex3.java");
        Stream<String> streamOfLines = Stream.empty();
        try {
            streamOfLines = Files.lines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        streamOfLines.forEach(System.out::println);
    }
}
