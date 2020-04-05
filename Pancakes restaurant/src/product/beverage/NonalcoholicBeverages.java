package product.beverage;

public class NonalcoholicBeverages extends Beverage {
    public NonalcoholicBeverages() {
        super();
    }

    public NonalcoholicBeverages(double price, String name, double weightLiters) {
        super(price, name, weightLiters);
    }

    @Override
    public String toString() {
        return "Nonalcoholic Beverage name=" + super.getName() +
                ", price=" + super.getPrice() +
                ", liters=" + super.getWeightLiters();
    }
}
