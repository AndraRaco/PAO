package exercitiul2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // Read from file
        ArrayList<Integer> arrayList1 = new ArrayList<Integer>();
        ArrayList<Double> arrayList2 = new ArrayList<Double>();

        try {
            createFileWithRandomNumbers();
            Scanner scanner = new Scanner(new File("date.in"));
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int number = scanner.nextInt();
                    arrayList1.add(number);
                } else if (scanner.hasNextDouble()) {
                    double number = scanner.nextDouble();
                    arrayList2.add(number);
                } else {
                    System.err.println("Unknown element in file:" + scanner.next());
                }
            }
            Collections.sort(arrayList1);
            Collections.sort(arrayList2);

            System.out.println("Int: " + arrayList1);
            System.out.println("Double: " + arrayList2);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }


    }

    static void createFileWithRandomNumbers() throws IOException {
        File file = new File("date.in");
        if (file.createNewFile()) {
            System.out.println("File created");
        } else {
            System.out.println("File already exists");
        }

        try (
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter writer = new BufferedWriter(fileWriter)) {

            Random random = new Random();
            System.out.println("Generating a file with random numbers.");

            int size = 10 + random.nextInt(20);
            for (int i = 0; i < size; i++) {
                if (random.nextBoolean()) { // Write int
                    writer.write(Integer.toString(random.nextInt()));
                } else { // Write double
                    writer.write(Double.toString(random.nextDouble()));
                }
                writer.write(" ");
            }
        }

    }
}
