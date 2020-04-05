import person.Client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("Andra's Pancakes Restaurant");
        System.out.println(restaurant.getName());

        restaurant.readMenu();
        try {
            restaurant.showMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();

        restaurant.readEmployeeList();
        try {
            restaurant.showEmployeeList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();

        restaurant.readClientList();
        try {
            restaurant.showClientList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();

        // New Client in the restaurant
        restaurant.newClient();
        restaurant.newClient();
        restaurant.closeScanner();

        System.out.println("\nTotal money earned: " + restaurant.getMoneyEarned());// Total money earned

        restaurant.sortClientsAfterDate();
        try {
            restaurant.showClientList();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
