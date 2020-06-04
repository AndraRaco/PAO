package servicesPackage;

import functionCRUD.ClientCRUD;
import functionCRUD.ClientsWithoutReceiptCRUD;
import functionCRUD.EmployeesCRUD;
import functionCRUD.MenuCRUD;
import readWriteCSV.CSVReader;
import readWriteCSV.CSVWriter;
import restaurant.Restaurant;
import restaurant.person.Client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Services {
    CSVReader csvReader;

    public CSVReader getCsvReader() {
        return csvReader;
    }

    public void setCsvReader(CSVReader csvReader) {
        this.csvReader = csvReader;
    }

    public CSVWriter getCsvWriter() {
        return csvWriter;
    }

    public void setCsvWriter(CSVWriter csvWriter) {
        this.csvWriter = csvWriter;
    }

    public EmployeesCRUD getEmCRUD() {
        return emCRUD;
    }

    public void setEmCRUD(EmployeesCRUD emCRUD) {
        this.emCRUD = emCRUD;
    }

    public MenuCRUD getMenuCRUD() {
        return menuCRUD;
    }

    public void setMenuCRUD(MenuCRUD menuCRUD) {
        this.menuCRUD = menuCRUD;
    }

    public ClientCRUD getClientCRUD() {
        return clientCRUD;
    }

    public void setClientCRUD(ClientCRUD clientCRUD) {
        this.clientCRUD = clientCRUD;
    }

    public ClientsWithoutReceiptCRUD getNewClientCRUD() {
        return newClientCRUD;
    }

    public void setNewClientCRUD(ClientsWithoutReceiptCRUD newClientCRUD) {
        this.newClientCRUD = newClientCRUD;
    }

    CSVWriter csvWriter;
    EmployeesCRUD emCRUD;
    MenuCRUD menuCRUD;
    ClientCRUD clientCRUD;
    ClientsWithoutReceiptCRUD newClientCRUD;
    private Restaurant restaurant;

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

    public void readAllDataFromDatabase() throws SQLException {
        // Read the List of Employees
        emCRUD.read(restaurant);
//        Employee newEmployee = new Employee("name", 0, "job");
//        emCRUD.create(restaurant, newEmployee);
//        emCRUD.updateAge(restaurant, newEmployee, 23);
//        emCRUD.delete(restaurant, newEmployee);


        // Read the Menu
        menuCRUD.read(restaurant.getMenu());
//        Pancake pancake = new Pancake();
//        menuCRUD.create(restaurant.getMenu(), pancake);
//        menuCRUD.delete(restaurant.getMenu(),4);

        // Read the List of Clients that have ordered and the ones that have not
        clientCRUD.read(restaurant); // Clients that have already ordered
//        clientCRUD.updateIDAndReceiptID(restaurant);// Update id with the allocated hashCode
//        Client newClient = new Client("andrei", 22);
//        clientCRUD.create(restaurant, newClient);
//        clientCRUD.delete(restaurant, newClient);


        newClientCRUD.read(restaurant); // Clients that didn't order yet
//        newClientCRUD.updateAge(restaurant, 5, 19);
//        Client newClient = new Client("adi", 22);
//        newClientCRUD.create(restaurant, newClient);
//        newClientCRUD.delete(restaurant, newClient);
    }

    public void takeOrderFromNewClients() {
        // Clients indexes of the clients that didn't order
        ArrayList<Integer> indexesOfClientsDidNotOrdered = restaurant.clientsDidNotOrdered();

        // Take the orders from the new clients
        for (int i = 0; i < indexesOfClientsDidNotOrdered.size(); i++) {
            Client client = restaurant.getClients().get(indexesOfClientsDidNotOrdered.get(i));
            restaurant.takeOrder(client);
            newClientCRUD.delete(restaurant, client);
            clientCRUD.create(restaurant, client);
        }
    }

    public void welcomeNewClient() {
        Client client = restaurant.newClient();
        newClientCRUD.create(restaurant, client);
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

