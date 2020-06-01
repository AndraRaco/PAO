package product.pancakes;

import product.Product;

import java.util.ArrayList;

public class Pancake extends Product {
    private double weightGrams;
    private int numberIngredients;
    private String type; // Salty or Sweet
    ArrayList<Ingredient> ingredientList;

    public Pancake() {
        super();
        type = "";
        weightGrams = 0;
        numberIngredients = 0;
        ingredientList = new ArrayList<Ingredient>();
    }

    public Pancake(String name, double price, String type, double weight, int numberIngredients) {
        super(price, name);
        this.type = type;
        this.weightGrams = weight;
        if (numberIngredients > 0)
            this.numberIngredients = numberIngredients;
        else {
            throw new RuntimeException("The number is not positive");
        }
        this.ingredientList = new ArrayList<Ingredient>();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWeightGrams() {
        return weightGrams;
    }

    public void setWeightGrams(double weightGrams) {
        this.weightGrams = weightGrams;
    }

    public int getNumberIngredients() {
        return numberIngredients;
    }

    public void setNumberIngredients(int numberIngredients) {
        this.numberIngredients = numberIngredients;
    }

    public ArrayList<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(ArrayList<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public double getWeight() {
        return weightGrams;
    }

    public void setWeight(double weight) {
        this.weightGrams = weight;
    }

    public String toStringShowIngredients() {
        StringBuilder str = new StringBuilder(type + " pancake " + " name=" + super.getName() +
                ", price=" + super.getPrice()
                + ", grams="
                + weightGrams + "\n");
        str.append("Ingredients: ");
        for (int i = 0; i < numberIngredients; i++)
            str.append(ingredientList.get(i)).append("; ");
        return str.toString();
    }

    public String ingredientsAndGrams() {
        String string = "";
        for (int i = 0; i < numberIngredients; i++) {
            string += ingredientList.get(i).getName();
            string += ",";
            string += ingredientList.get(i).getWeightGrams();
            string += ",";
        }
        return string;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(type + " pancake " + " name=" + super.getName() +
                ", price=" + super.getPrice()
                + ", grams="
                + weightGrams);
        return str.toString();
    }

    public void add(Ingredient newIngredient) {
        if (numberIngredients > ingredientList.size()) {
            ingredientList.add(newIngredient);
        }
    }
}
