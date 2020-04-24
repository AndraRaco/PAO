import readWriteCSV.CSVReader;
import restaurant.Restaurant;

import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Services services = new Services("Andra's Pancakes Restaurant");
        System.out.println(services.getRestaurant());

        // Read data from CVS
        services.readAllDataFromCSV();

        // The scanner that have been open in the restaurant
        Scanner scanner = services.getRestaurant().getScanner();

        // Menu of Services
        boolean endApp = false;
        while (!endApp) {
            services.printListOfActions();
            int choice = services.readChoice();

            switch (choice) {
                case 1: {
                    // 1. Show The Name of the Restaurant
                    services.nameOfTheRestaurant();
                    break;
                }
                case 2: {
                    // 2. Show Menu
                    services.showMenu();
                    break;
                }
                case 3: {
                    // 3. Show The List of Employees.
                    services.showEmployeesList();
                    break;
                }
                case 4: {
                    // 4. Show The List of Clients.
                    services.showClientsList();
                    break;
                }
                case 5: {
                    // 5. Show Total Money Earned.
                    services.showTotalMoneyEarned();
                    break;
                }
                case 6: {
                    // 6. Show what ordered client with the index you enter.
                    System.out.println("The index of the client you want to see, give me an number between 1 and " + services.getRestaurant().sizeOfClientsList() + ": ");
                    int index;
                    while (true) {
                        index = Integer.parseInt(scanner.nextLine());
                        index--;
                        if (index >= 1 && index <= services.getRestaurant().sizeOfClientsList())
                            break;
                        else
                            System.out.println("The number should be between 1 and " + services.getRestaurant().sizeOfClientsList() + ". Another number: ");
                    }
                    services.printWhatOrderedClientWithIndex(index);
                    break;
                }
                case 7: {
                    // 7. Information about one of the waiters.
                    services.oneOfTheWaiters();
                    break;
                }
                case 8: {
                    // 8. Sort Clients after Date.
                    services.sortClientsAfterDate();
                    services.showClientsList();
                    break;
                }
                case 9: {
                    // 9. Welcome new Client and take their information.
                    services.welcomeNewClient();
                    break;
                }
                case 10:{
                    // 10. Take the orders from the new Clients.
                    services.takeOrderFromNewClients();
                    break;}
                case 11:{
                    // 11. Close The Application.
                    endApp=true;
                    // Close the restaurant's scanner
                    services.getRestaurant().closeScanner();
                    break;}
                default:
                    break;
            }
            System.out.println();
        }
    }
}
