package restaurant;

import restaurant.person.Client;
import restaurant.person.Employee;
import restaurant.person.Receipt;
import restaurant.product.Product;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Restaurant {
    private String name;
    private Set<Employee> employees;
    private Menu menu;
    private ArrayList<Client> clients;
    private double moneyEarned;
    private Scanner scanner;

    public Restaurant() {
        name = "";
        employees = new HashSet<Employee>();
        menu = new Menu();
        clients = new ArrayList<Client>();
        moneyEarned = 0;
        scanner = new Scanner(System.in);
    }

    public Restaurant(String name) {
        this.name = name;
        this.moneyEarned = 0;
        menu = new Menu();
        clients = new ArrayList<Client>();
        employees = new HashSet<Employee>();
        scanner = new Scanner(System.in);
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public double getMoneyEarned() {
        return moneyEarned;
    }

    public void setMoneyEarned(double moneyEarned) {
        this.moneyEarned = moneyEarned;
    }

    public void showEmployeeList() throws Exception {
        if (employees.size() > 0) {

            System.out.println("Employees");
            Iterator<Employee> iterator = employees.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } else {
            throw new Exception("Employee List wasn't read.");
        }
    }

    public void showClientList() throws Exception {
        if (clients.size() > 0) {

            System.out.println("Clients");
            for (int i = 0; i < clients.size(); i++) {
                System.out.println(i + 1);
                System.out.println(clients.get(i));
                printProductsFromReceipt(i);
            }
        } else {
            throw new Exception("Client List wasn't read.");
        }
    }

    public void showMenu() throws Exception { // Lists the menu
        if (menu.getNumberProducts() > 0) {

            menu.print();
        } else {
            throw new Exception("Menu wasn't read.");
        }
    }

    public void printProductsFromReceipt(int indexClient) {
        Client client = clients.get(indexClient);
        Receipt receipt = client.getReceipt();
        for (int i = 0; i < receipt.getNumberOfDishes(); i++) {
            int index = receipt.dishNumber(i);
            Product product = menu.getProductFromMenu(index);
            System.out.println(product);
        }
    }

    public void actualizeMoneyEarned(double receiptTotalOrder) {
        moneyEarned += receiptTotalOrder;
    }

    public Employee waiter() throws Exception {
        String str = "waiter";

        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = (Employee) iterator.next();
            if (employee.getJobName().equals(str)) {
                return employee;
            }
        }
        throw new Exception("The restaurant has no waiter hired.");
    }

    public void takeOrder(Client client) {
        try {
            Employee employee = this.waiter();
            System.out.println(employee.toString() + " takes the order from " + client.toString());
            System.out.println("Number of products (beverage + pancakes) you want to order:");
            int numberOfProducts = Integer.parseInt(scanner.nextLine());
            Receipt receipt = client.getReceipt();
            for (int i = 0; i < numberOfProducts; i++) {
                System.out.println("Index of the dish in the menu between 1 and " + menu.sizeOfMenu() + ":");
                int index = Integer.parseInt(scanner.nextLine()) - 1;
                receipt.addDish(index);
                double priceDish = menu.priceOfAProduct(index);
                receipt.addPriceOfAProductToTotalOrder(priceDish);
            }
            this.actualizeMoneyEarned(receipt.getTotalOrder());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Client newClient() {//Returns the client
        System.out.println("New client information: ");
        System.out.println("name=");
        String name = scanner.nextLine();
        System.out.println("age=");
        int age = Integer.parseInt(scanner.nextLine());
        Client client = new Client(name, age);
        takeOrder(client);
        clients.add(client);
        return client;
    }

    public void closeScanner() {
        scanner.close();
    }

    public void sortClientsAfterDate() {
        clients.sort(Client::compareTo);
    }

    public void addClient(Client client) {
        clients.add(client);
    }
}
