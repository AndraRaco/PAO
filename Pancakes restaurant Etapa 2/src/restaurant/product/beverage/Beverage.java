package restaurant.product.beverage;

import restaurant.product.Product;

public class Beverage extends Product {
    private double weightLiters;

    public Beverage() {
        super();
        weightLiters = 0;
    }

    public Beverage(double price, String name, double weightLiters) {
        super(price, name);
        this.weightLiters = weightLiters;
    }


    public double getWeightLiters() {
        return weightLiters;
    }

    public void setWeightLiters(double weightLiters) {
        this.weightLiters = weightLiters;
    }

    @Override
    public String toString() {
        return "Beverage{" +
                "name='" + super.getName() + '\'' +
                ", weightLiters=" + weightLiters +
                '}';
    }
}
