import java.util.Comparator;

public class MovieNameLengthComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie o1, Movie o2) {
        return o2.getName().length() - o1.getName().length();
    }