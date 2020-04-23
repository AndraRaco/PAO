package restaurant;

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
