
import restaurant.product.Product;
import restaurant.product.beverage.AlcoholicBeverage;
import restaurant.product.beverage.NonalcoholicBeverages;
import restaurant.product.pancakes.Ingredient;
import restaurant.product.pancakes.Pancake;

import java.io.*;
import java.util.ArrayList;


public class Menu {
    private int numberProducts;
    private ArrayList<Product> menu;

    public Menu() {
        this.numberProducts = 0;
        this.menu = new ArrayList<Product>();
    }

    public Menu(int numberProducts) {
        if (numberProducts > 0) {
            this.numberProducts = numberProducts;
        } else {
            throw new RuntimeException("The number is not positive");
        }
        this.menu = new ArrayList<Product>();
    }

    public int getNumberProducts() {
        return numberProducts;
    }

    public void setNumberProducts(int numberProducts) {
        this.numberProducts = numberProducts;
    }

    public ArrayList<Product> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<Product> menu) {
        this.menu = menu;
    }

    public Product getProductFromMenu(int index) {
        if (index >= 0 && index < numberProducts) {
            return menu.get(index);
        } else throw new ArrayIndexOutOfBoundsException("Index is not between 0 and " + (numberProducts - 1));
    }

    public void read() {
        File file = new File("menu.txt");
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            String string;
            numberProducts = Integer.parseInt(br.readLine());
            for (int i = 0; i < numberProducts; i++)
                if ((string = br.readLine()) != null) {
                    String[] strings = string.split(" ");
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
    }

    public void print() {
        System.out.println("Menu");
        for (int i = 0; i < numberProducts; i++) {
            Product product = menu.get(i);
            if (product instanceof Pancake)
                System.out.println((i + 1) + ". " + ((Pancake) product).toStringShowIngredients());
            else System.out.println((i + 1) + ". " + product.toString());
        }
    }

    public double priceOfAProduct(int indexProduct) {
        return menu.get(indexProduct).getPrice();
    }

    public int sizeOfMenu() {
        return menu.size();
    }
}
