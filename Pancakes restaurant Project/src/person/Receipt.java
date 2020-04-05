package person;

import product.Product;

import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.Date;

public class Receipt {
    final private int id;
    private Date date;
    private int numberOfDishes;
    private ArrayList<Integer> numberDish; // Number from the menu

    public Receipt() {
        super();
        id = hashCode();
        date = new Date();
        numberOfDishes = 0;
        numberDish = new ArrayList<Integer>();
    }

    public Receipt(Date date, int numberOfProducts) {
        this.id = hashCode();
        this.date = date;
        this.numberOfDishes = numberOfProducts;
        this.numberDish = new ArrayList<Integer>();
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
    }

    public int dishNumber(int index) {
        if (index >= 0 && index < numberOfDishes)
            return numberDish.get(index).intValue();
        else throw new ArrayIndexOutOfBoundsException("Index is not between 0 and"+(numberOfDishes-1));
    }
}
