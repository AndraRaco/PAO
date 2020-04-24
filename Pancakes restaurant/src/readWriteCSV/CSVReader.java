package readWriteCSV;

import restaurant.Menu;
import restaurant.Restaurant;
import restaurant.person.Client;
import restaurant.person.Employee;
import restaurant.person.Receipt;
import restaurant.product.Product;
import restaurant.product.beverage.AlcoholicBeverage;
import restaurant.product.beverage.NonalcoholicBeverages;
import restaurant.product.pancakes.Ingredient;
import restaurant.product.pancakes.Pancake;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

public class CSVReader {
    // Singleton class used to read CSV files
    private static CSVReader instance;

    private CSVReader() {
    }

    public static CSVReader getInstance() {
        if (instance == null) {
            instance = new CSVReader();
        }
        return instance;
    }

    public void readSetOfEmployees(Restaurant restaurant) {
        File file = new File("employees.csv");
        BufferedReader br;
        String csvSplitBy = ",";

        Set<Employee> employees = restaurant.getEmployees();
        try {
            br = new BufferedReader(new FileReader(file));
            String string;
            while ((string = br.readLine()) != null) {
                String[] strings = string.split(csvSplitBy);
                String name = strings[0];
                int age = Integer.parseInt(strings[1]);
                String job = strings[2];
                Employee newEmployee = new Employee(name, age, job);
                employees.add(newEmployee);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readOldClientsList(Restaurant restaurant) {//Clients that have receipt
        File file = new File("clients with receipt.csv");
        BufferedReader br;
        String csvSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(file));
            String string;
            while ((string = br.readLine()) != null) {
                String[] strings = string.split(csvSplitBy);
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
                Menu menu = restaurant.getMenu();
                for (int i = 0; i < numberOfDishes; i++) {
                    int index = Integer.parseInt(strings[4 + i + 1]) - 1;
                    receipt.addDish(index);
                    double priceDish = menu.priceOfAProduct(index);
                    receipt.addPriceOfAProductToTotalOrder(priceDish);
                }
                Client newClient = new Client(name, age, receipt);
                restaurant.actualizeMoneyEarned(newClient.receiptTotalOrder());
                restaurant.addClient(newClient);

            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readMenu(Menu menuRestaurant) {
        File file = new File("menu.csv");
        BufferedReader br;
        String csvSplitBy = ",";
        ArrayList<Product> menu = menuRestaurant.getMenu();
        int numberProducts = 0;
        try {
            br = new BufferedReader(new FileReader(file));
            String string;
            while ((string = br.readLine()) != null) {
                numberProducts++;
                String[] strings = string.split(csvSplitBy);
                if (strings[1].equals("drink")) {
                    if (strings[0].equals("nonalcoholic")) {
                        String name = strings[2];
                        double price = Double.parseDouble(strings[3]);
                        double weightLiters = Double.parseDouble(strings[4]);
                        Product product = new NonalcoholicBeverages(price, name, weightLiters);
                        menu.add(product);
                    } else if (strings[0].equals("alcoholic")) {
                        String name = strings[2];
                        double price = Double.parseDouble(strings[3]);
                        double weightLiters = Double.parseDouble(strings[4]);
                        double alcoholMeasurements = Double.parseDouble(strings[5]);
                        Product product = new AlcoholicBeverage(price, name, weightLiters, alcoholMeasurements);
                        menu.add(product);
                    }
                } else if (strings[1].equals("pancake")) {
                    String name = strings[2];
                    String type = strings[0];
                    double price = Double.parseDouble(strings[3]);
                    double weightGrams = Double.parseDouble(strings[4]);
                    int numberIngredients = Integer.parseInt(strings[5]);
                    Product product = new Pancake(name, price, type, weightGrams, numberIngredients);
                    int k = 6;
                    for (int j = 0; j < numberIngredients; j++) {
                        Ingredient newIngredient = new Ingredient(strings[k++], Double.parseDouble(strings[k++]));
                        ((Pancake) product).add(newIngredient);
                    }
                    menu.add(product);
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        menuRestaurant.setNumberProducts(numberProducts);
    }

    public void readClientsList(Restaurant restaurant) { // Clients that did not ordered yet
        File file = new File("clients.csv");
        BufferedReader br;
        String csvSplitBy = ",";

        ArrayList<Client> clients = restaurant.getClients();
        try {
            br = new BufferedReader(new FileReader(file));
            String string;
            while ((string = br.readLine()) != null) {
                String[] strings = string.split(csvSplitBy);
                String name = strings[0];
                int age = Integer.parseInt(strings[1]);
                Client newClient=new Client(name,age);
                clients.add(newClient);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
