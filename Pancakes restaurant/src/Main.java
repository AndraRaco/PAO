import functionCRUD.EmployeesCRUD;
import person.Employee;
import readWriteCSV.CSVReader;
import restaurant.Restaurant;

import java.nio.channels.ScatteringByteChannel;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Services services = new Services("Andra's Pancakes Restaurant");
        System.out.println(services.getRestaurant());

        // Read data from CVS
        Date timestamp=new Date();
        try {
            services.readAllDataFromCSV();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.println("A");
//        services.writeActionInCSV("Read all data from CSV", timestamp);
//
//        // The scanner that have been open in the restaurant
//        Scanner scanner = services.getRestaurant().getScanner();
//
//        // Menu of Services
//        boolean endApp = false;
//        while (!endApp) {
//            services.printListOfActions();
//            int choice = services.readChoice();
//
//            switch (choice) {
//                case 1: {
//                    // 1. Show The Name of the Restaurant
//                    services.nameOfTheRestaurant();
//                    timestamp= Calendar.getInstance().getTime();
//                    services.writeActionInCSV("Show The Name of the Restaurant", timestamp);
//                    break;
//                }
//                case 2: {
//                    // 2. Show Menu
//                    services.showMenu();
//                    timestamp= Calendar.getInstance().getTime();
//                    services.writeActionInCSV("Show Menu", timestamp);
//                    break;
//                }
//                case 3: {
//                    // 3. Show The List of Employees.
//                    services.showEmployeesList();
//                    timestamp= Calendar.getInstance().getTime();
//                    services.writeActionInCSV("Show The List of Employees", timestamp);
//                    break;
//                }
//                case 4: {
//                    // 4. Show The List of Clients.
//                    services.showClientsList();
//                    timestamp= Calendar.getInstance().getTime();
//                    services.writeActionInCSV("Show The List of Clients", timestamp);
//                    break;
//                }
//                case 5: {
//                    // 5. Show Total Money Earned.
//                    services.showTotalMoneyEarned();
//                    timestamp= Calendar.getInstance().getTime();
//                    services.writeActionInCSV("Show Total Money Earned", timestamp);
//                    break;
//                }
//                case 6: {
//                    // 6. Show what ordered client with the index you enter.
//                    System.out.println("The index of the client you want to see, give me an number between 1 and " + services.getRestaurant().sizeOfClientsList() + ": ");
//                    int index;
//                    while (true) {
//                        index = Integer.parseInt(scanner.nextLine());
//                        index--;
//                        if (index >= 1 && index <= services.getRestaurant().sizeOfClientsList())
//                            break;
//                        else
//                            System.out.println("The number should be between 1 and " + services.getRestaurant().sizeOfClientsList() + ". Another number: ");
//                    }
//                    services.printWhatOrderedClientWithIndex(index);
//                    timestamp= Calendar.getInstance().getTime();
//                    services.writeActionInCSV("Show what ordered client with the index you enter", timestamp);
//                    break;
//                }
//                case 7: {
//                    // 7. Information about one of the waiters.
//                    services.oneOfTheWaiters();
//                    timestamp= Calendar.getInstance().getTime();
//                    services.writeActionInCSV("Information about one of the waiters", timestamp);
//                    break;
//                }
//                case 8: {
//                    // 8. Sort Clients after Date.
//                    services.sortClientsAfterDate();
//                    services.showClientsList();
//                    timestamp= Calendar.getInstance().getTime();
//                    services.writeActionInCSV("Sort Clients after Date", timestamp);
//                    break;
//                }
//                case 9: {
//                    // 9. Welcome new Client and take their information.
//                    services.welcomeNewClient();
//                    timestamp= Calendar.getInstance().getTime();
//                    services.writeActionInCSV("Welcome new Client and take their information", timestamp);
//                    break;
//                }
//                case 10:{
//                    // 10. Take the orders from the new Clients.
//                    services.takeOrderFromNewClients();
//                    timestamp= Calendar.getInstance().getTime();
//                    services.writeActionInCSV("Take the orders from the new Clients", timestamp);
//                    break;}
//                case 11:{
//                    // 11. Close The Application.
//                    endApp=true;
//                    timestamp= Calendar.getInstance().getTime();
//                    services.writeActionInCSV("Close The Application", timestamp);
//                    // Close the restaurant's scanner
//                    services.getRestaurant().closeScanner();
//                    services.closeCSVWriter();
//                    break;}
//                default:
//                    break;
//            }
//            System.out.println();
//        }
    }
}
