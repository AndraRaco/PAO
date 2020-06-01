package restaurant.person;

import java.util.ArrayList;
import java.util.Date;

public class Receipt {
    final private int id;
    private Date date;
    private int numberOfDishes;
    private ArrayList<Integer> numberDish; // Number from the menu
    private double totalOrder;

    public Receipt() {
        super();
        id = hashCode();
        date = new Date();
        numberOfDishes = 0;
        numberDish = new ArrayList<Integer>();
        totalOrder = 0;
    }

    public Receipt(Date date, int numberOfProducts) {
        this.id = hashCode();
        this.date = date;
        this.numberOfDishes = numberOfProducts;
        this.numberDish = new ArrayList<Integer>();
        totalOrder = 0;
    }

    public ArrayList<Integer> getNumberDish() {
        return numberDish;
    }

    public void setNumberDish(ArrayList<Integer> numberDish) {
        this.numberDish = numberDish;
    }

    public double getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(double totalOrder) {
        this.totalOrder = totalOrder;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNumberOfDishes() {
        return numberOfDishes;
    }

    public void setNumberOfDishes(int numberOfProducts) {
        this.numberOfDishes = numberOfProducts;
    }

    @Override
    public String toString() {

        String str = "\nRecipt " +
                "id=" + id +
                ", date=" + date;
        return str;
    }

    public void addDish(int dishNumber) {
        numberDish.add(dishNumber);
        if (numberDish.size() > numberOfDishes)
            numberOfDishes++;
    }

    public int dishNumber(int index) {
        if (index >= 0 && index < numberOfDishes)
            return numberDish.get(index).intValue();
        else throw new ArrayIndexOutOfBoundsException("Index is not between 0 and" + (numberOfDishes - 1));
    }

    public void addPriceOfAProductToTotalOrder(double priceProduct) {
        totalOrder += priceProduct;
    }
}