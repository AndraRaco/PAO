package product.beverage;

public class AlcoholicBeverage extends Beverage {
    private double alcoholMeasurements;

    public AlcoholicBeverage() {
        super();
    }

    public AlcoholicBeverage(double price, String name, double weightLiters, double alcoholMeasurements) {
        super(price, name, weightLiters);
        this.alcoholMeasurements = alcoholMeasurements;
    }

    public double getAlcoholMeasurements() {
        return alcoholMeasurements;
    }

    public void setAlcoholMeasurements(double alcoholMeasurements) {
        this.alcoholMeasurements = alcoholMeasurements;
    }

    @Override
    public String toString() {
        return "Alcoholic Beverage name=" + super.getName() +
                ", price=" + super.getPrice() +
                ", liters=" + super.getWeightLiters() +
                ", alcohol measurements=" + alcoholMeasurements;
    }
}
