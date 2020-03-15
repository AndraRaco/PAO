package hello;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args)
    {
        //A simple text scanner which can parse
        Scanner scanner=new Scanner(System.in);// Alt+Enter to add Scanner
        System.out.println("Enter your name: ");

        //here we actually read keyboard input
        String myName=scanner.nextLine();

        //close the resource!!!
        scanner.close();

        //display the input to console
        System.out.println("My name is: "+myName);
    }

}
