import functionCRUD.ClientCRUD;
import functionCRUD.ClientsWithoutReceiptCRUD;
import functionCRUD.EmployeesCRUD;
import functionCRUD.MenuCRUD;
import readWriteCSV.CSVReader;
import readWriteCSV.CSVWriter;
import restaurant.Restaurant;
import restaurant.person.Client;
import restaurant.product.beverage.AlcoholicBeverage;
import restaurant.product.beverage.NonalcoholicBeverages;
import restaurant.product.pancakes.Pancake;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Services {
    private Restaurant restaurant;
    CSVReader csvReader;
    CSVWriter csvWriter;
    EmployeesCRUD emCRUD;
    MenuCRUD menuCRUD;
    ClientCRUD clientCRUD;
    ClientsWithoutReceiptCRUD newClientCRUD;

    public Services(String restaurant) {
        this.restaurant = new Restaurant();
        this.restaurant.setName(restaurant);
        csvReader = CSVReader.getInstance();
        csvWriter = CSVWriter.getInstance();
        emCRUD = new EmployeesCRUD();
        menuCRUD = new MenuCRUD();
        clientCRUD = new ClientCRUD();
        newClientCRUD = new ClientsWithoutReceiptCRUD();
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void writeActionInCSV(String string, Date timestamp) {
        csvWriter.writeInCSV(string, timestamp);
    }

    public void readAllDataFromCSV() throws SQLException {
        // Read the List of Employees
        emCRUD.read(restaurant);

        // Read the Menu
        menuCRUD.read(restaurant.getMenu());
//        Pancake pancake = new Pancake();
//        menuCRUD.create(restaurant.getMenu(), pancake);
//        menuCRUD.delete(restaurant.getMenu(),4);

        // Read the List of Clients that have ordered and the ones that have not
        clientCRUD.read(restaurant); // Clients that have already ordered
        clientCRUD.updateIDAndReceiptID(restaurant);// Update id with the allocated hashCode

        newClientCRUD.read(restaurant); // Clients that didn't order yet
    }

    public void takeOrderFromNewClients() {
        // Clients indexes of the clients that didn't order
        ArrayList<Integer> indexesOfClientsDidNotOrdered = restaurant.clientsDidNotOrdered();

        // Take the orders from the new clients
        for (int i = 0; i < indexesOfClientsDidNotOrdered.size(); i++) {
            Client client = restaurant.getClients().get(indexesOfClientsDidNotOrdered.get(i));
            restaurant.takeOrder(client);
        }
    }

    public void welcomeNewClient() {
        restaurant.newClient();
    }

    public void sortClientsAfterDate() {
        restaurant.sortClientsAfterDate();
    }

    public void oneOfTheWaiters() {
        try {
            System.out.println("One of the waiters of the restaurant is: " + restaurant.waiter());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printWhatOrderedClientWithIndex(int indexClient) {
        // Have to ask the index
        restaurant.printProductsFromReceipt(indexClient);
    }

    public void showMenu() {
        try {
            restaurant.showMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showClientsList() {
        try {
            restaurant.showClientList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showEmployeesList() {
        try {
            restaurant.showEmployeeList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showTotalMoneyEarned() {
        System.out.println("Total money earned: " + restaurant.getMoneyEarned());
    }

    public void nameOfTheRestaurant() {
        System.out.println("The name of the restaurant is: " + restaurant.getName());
    }

    public int readChoice() {
        Scanner scanner = restaurant.getScanner();
        System.out.println("Choose one option, the number should be between 1 and 11: ");
        int choice = -1;

        while (true) {
            choice = Integer.parseInt(scanner.nextLine());
            if (choice >= 1 && choice <= 11)
                break;
            else System.out.println("The number should be between 1 and 11. Another number: ");
        }
        return choice;
    }

    public void closeCSVWriter() {
        csvWriter.close();
    }

    public void printListOfActions() {
        System.out.println("List of services: ");
        System.out.println("1. Show The Name of the Restaurant.");
        System.out.println("2. Show Menu.");
        System.out.println("3. Show The List of Employees.");
        System.out.println("4. Show The List of Clients.");
        System.out.println("5. Show Total Money Earned.");
        System.out.println("6. Show what ordered client with the index you enter.");
        System.out.println("7. Information about one of the waiters.");
        System.out.println("8. Sort Clients after Date.");
        System.out.println("9. Welcome new Client and take their information.");
        System.out.println("10. Take the orders from the new Clients.");
        System.out.println("11. Close The Application.");
        System.out.println();
    }
}

