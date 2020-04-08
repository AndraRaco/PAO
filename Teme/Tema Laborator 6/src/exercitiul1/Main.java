package exercitiul1;

import exercitiul1.exceptions.MyArithmeticException;
import exercitiul1.exceptions.NullParameterException;
import exercitiul1.exceptions.OverflowException;
import exercitiul1.exceptions.UnderflowException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DoubleOperation doubleOperation = new DoubleOperation();
        Double result;

        // Add exceptions
        // NullParameterException
        try {
            result = doubleOperation.add(null, 3.0);
            System.out.println(result);
        } catch (NullParameterException e) {
            e.printStackTrace();
        } catch (OverflowException e) {
            e.printStackTrace();
        } catch (UnderflowException e) {
            e.printStackTrace();
        }

        // OverflowException
        try {
            result = doubleOperation.add(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
            System.out.println(result);
        } catch (NullParameterException e) {
            e.printStackTrace();
        } catch (OverflowException e) {
            e.printStackTrace();
        } catch (UnderflowException e) {
            e.printStackTrace();
        }

        // UnderflowException
        try {
            result = doubleOperation.add(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
            System.out.println(result);
        } catch (NullParameterException e) {
            e.printStackTrace();
        } catch (OverflowException e) {
            e.printStackTrace();
        } catch (UnderflowException e) {
            e.printStackTrace();
        }


        // Divide Exceptions
        // NullParameterException
        try {
            result = doubleOperation.divide(null, 3.0);
            System.out.println(result);
        } catch (NullParameterException e) {
            e.printStackTrace();
        } catch (MyArithmeticException e) {
            e.printStackTrace();
        }

        // MyArithmeticException
        try {
            result = doubleOperation.divide(4.0, 0.0);
            System.out.println(result);
        } catch (NullParameterException e) {
            e.printStackTrace();
        } catch (MyArithmeticException e) {
            e.printStackTrace();
        }

        // Read from file
        ArrayList<Double> arrayList = new ArrayList<Double>();
        try {
            createFile();
            Scanner scanner = new Scanner(new File("date.in"));
            while (scanner.hasNextDouble()) {
                double number = scanner.nextDouble();
                arrayList.add(number);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Average Exceptions
        try {
            result = doubleOperation.average(arrayList);
            System.out.println(result);
        } catch (NullParameterException e) {
            e.printStackTrace();
        } catch (OverflowException e) {
            e.printStackTrace();
        } catch (UnderflowException e) {
            e.printStackTrace();
        } catch (MyArithmeticException e) {
            e.printStackTrace();
        }
    }

    static void createFile() throws IOException {
        File file = new File("date.in");
        if (file.createNewFile()) {
            System.out.println("File created");
        } else {
            System.out.println("File already exists");
        }
    }
}
