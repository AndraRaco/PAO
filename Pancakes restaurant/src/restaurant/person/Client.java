package restaurant.person;

import java.awt.*;
import java.util.Date;

public class Client extends Person implements Comparable<Client> {
    private final int id;
    private Receipt receipt;

    public Client(String name, int age) {
        super(name, age);
        this.id = hashCode();
        receipt = new Receipt();
    }

    public Client() {
        super();
        this.id = hashCode();
        receipt = new Receipt();
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public Client(String name, int age, Receipt receipt) {
        super(name, age);
        this.id = hashCode();
        this.receipt = receipt;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        String str = "Client " +
                "id=" + id + ", name=" + super.getName() + ", age=" + super.getAge();
        str += receipt.toString();
        return str;
    }

    public double receiptTotalOrder() {
        return receipt.getTotalOrder();
    }

    public void addProductToTheReceipt(int DishNumber) {
        receipt.addDish((Integer) DishNumber);
    }

    @Override
    public int compareTo(Client client) {
        Date date1 = this.getReceipt().getDate();
        Date date2 = client.getReceipt().getDate();
        return date1.compareTo(date2);
    }
}
