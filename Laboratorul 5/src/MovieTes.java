import java.lang.reflect.Array;
import java.util.Arrays;

public class MovieTest {

    public static void main(String[] args) {

        Movie[] movies = { new Movie("Breaking bad", 2014, 9.4), new Movie("Star wars", 1977, 8.8),
                new Movie("die hard ", 1990, 8), new Movie("planet of the apes ", 1976, 8),
                new Movie("Terminator", 1994, 7.5) };

        System.out.println("Before sorting: " + Arrays.toString(movies));
        // sort the array using the order provided by implementing Comparable interface
        Arrays.sort(movies);
        System.out.println("Ascending by year sort: " + Arrays.toString(movies));

        // sort the array by using a movie rating comparator
        Arrays.sort(movies, new MovieRatingComparator());
        System.out.println("Ascending by rating sort: " + Arrays.toString(movies));

        // sort the array by using a movie name length comparator
        Arrays.sort(movies, new MovieNameLengthComparator());
        System.out.println("Descending by name length sort: " + Arrays.toString(movies));

        /*
         * chain comparators: first sort ascending by rating (but reversed -> so
         * descending), then descending by name length
         */
        Arrays.sort(movies, new MovieRatingComparator().reversed().thenComparing(new MovieNameLengthComparator()));
        System.out.println("Descending by rating and descending by name lenght sort: " + Arrays.toString(movies));

        // same order as with Comparable implementation, but this time using anonymous
        // comparator
        Arrays.sort(movies, (movie1, movie2) -> movie1.getYear() - movie2.getYear());
        System.out.println("Ascending by year sort: " + Arrays.toString(movies));
    }
}