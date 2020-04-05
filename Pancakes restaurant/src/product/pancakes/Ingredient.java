package product.pancakes;

public class Ingredient {
    private String name;
    private double weightGrams;

    public Ingredient() {
        name = "";
        weightGrams = 0;
    }

    public Ingredient(String name, double weightGrams) {
        this.name = name;
        this.weightGrams = weightGrams;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeightGrams() {
        return weightGrams;
    }

    public void setWeightGrams(double weightGrams) {
        this.weightGrams = weightGrams;
    }

    @Override
    public String toString() {
        return name +
                " " + weightGrams +
                " grams";
    }

}
