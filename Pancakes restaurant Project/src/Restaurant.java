import person.Client;
import person.Employee;
import person.Receipt;
import product.Product;

import javax.xml.crypto.Data;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Restaurant {
    private String name;
    private ArrayList<Employee> employees;
    private Menu menu;
    private ArrayList<Client> clients;
    private double moneyEarned;

    public Restaurant() {
        name = "";
        employees = new ArrayList<Employee>();
        menu = new Menu();
        clients = new ArrayList<Client>();
        moneyEarned = 0;
    }

    public Restaurant(String name) {
        this.name = name;
        this.moneyEarned = 0;
        menu = new Menu();
        clients = new ArrayList<Client>();
        employees = new ArrayList<Employee>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
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

    public void readEmployeeList() {
        File file = new File("D:\\FMI\\ANUL 2\\Semestrul 2\\PAO\\Pancakes restaurant\\employees.txt");
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            String string;
            while ((string = br.readLine()) != null) {
                String[] strings = string.split(" ");
                String name = strings[0];
                int age = Integer.parseInt(strings[1]);
                String job = strings[2];
                Employee newEmployee = new Employee(name, age, job);
                employees.add(newEmployee);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showEmployeeList() {
        if (employees.size() <= 0) {
            readEmployeeList();
        }
        System.out.println("Employees");
        for (int i = 0; i < employees.size(); i++)
            System.out.println(employees.get(i));
    }

    public void readClientList() {
        File file = new File("D:\\FMI\\ANUL 2\\Semestrul 2\\PAO\\Pancakes restaurant\\clients with receipt.txt");
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            String string;
            while ((string = br.readLine()) != null) {
                String[] strings = string.split(" ");
                String name = strings[0];
                int age = Integer.parseInt(strings[1]);
                String stringDate = strings[2] + " " + strings[3];
                SimpleDateFormat formatter1 = new SimpleDateFormat("dd.MM.yyyy HH:mm");
                Date date = null;
                try {
                    date = formatter1.parse(stringDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int numberOfDishes = Integer.parseInt(strings[4]);
                Receipt receipt = new Receipt(date, numberOfDishes);
                for (int i = 0; i < numberOfDishes; i++) {
                    receipt.addDish(Integer.parseInt(strings[4 + i + 1]));
                }
                Client newClient = new Client(name, age, receipt);
                clients.add(newClient);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showClientList() {
        if (clients.size() <= 0) {
            readClientList();
        }
        System.out.println("Clients");
        for (int i = 0; i < clients.size(); i++) {
            System.out.println(i+1);
            System.out.println(clients.get(i));
            printProductsFromReceipt(i);
        }
    }

    public void showMenu() { // Lists the menu
        if (menu.getNumberProducts() <= 0) {
            menu.read();
        }
        menu.print();
    }

    public void printProductsFromReceipt(int indexClient) {
        Client client = clients.get(indexClient);
        Receipt receipt = client.getReceipt();
        for (int i = 0; i < receipt.getNumberOfDishes(); i++) {
            int index = receipt.dishNumber(i);
            Product product = menu.getProductFromMenu(index-1);
            System.out.println(product);
        }
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======

    public void actualizeMoneyEarned(double receiptTotalOrder) {
        moneyEarned += receiptTotalOrder;
    }

    public Employee waiter() throws Exception {
        String str = "waiter";

        Iterator iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = (Employee) iterator.next();
            if (employee.getJobName().equals(str)) {
                return employee;
            }
        }
        throw new Exception("The restaurant has no waiter hired.");
    }

    public Client newClient() {//Returns the client
        System.out.println("New client information: ");
        System.out.println("name=");
        String name = scanner.nextLine();
        System.out.println("age=");
        int age = Integer.parseInt(scanner.nextLine());
        Client client = new Client(name, age);
        clients.add(client);
        return client;
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

    public void closeScanner() {
        scanner.close();
    }

    public void sortClientsAfterDate() {
        clients.sort(Client::compareTo);
    }

>>>>>>> parent of 87edeae... takeOrder usage moved in newClient
=======
>>>>>>> parent of 152dd93... First Part of the Project
}
