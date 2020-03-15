import java.util.Arrays;

public class exemplu5 {
    public static void main(String[] args) {
        int[] ints = {2, 5, 555, 0, 22, 55, -234, 77};
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.binarySearch(ints, 555));

    }
}
