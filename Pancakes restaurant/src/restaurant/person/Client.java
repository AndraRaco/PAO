package restaurant.person;

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

    public Client(String name, int age, Receipt receipt) {
        super(name, age);
        this.id = hashCode();
        this.receipt = receipt;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        String str = "Client " +
                "id=" + id + ", name=" + super.getName() + ", age=" + super.getAge();
        if (receipt != null)
            str += receipt.toString();
        return str;
    }

    public double receiptTotalOrder() throws Exception {
        if (receipt != null)
            return receipt.getTotalOrder();
        else throw new Exception("There is no receipt, the order hasn't been taken.");
    }

    public void addProductToTheReceipt(int DishNumber) throws Exception {
        if (receipt != null)
            receipt.addDish((Integer) DishNumber);
        else throw new Exception("There is no receipt, the order hasn't been taken.");
    }

    @Override
    public int compareTo(Client client) {
        Date date1 = new Date(), date2 = new Date();
        if (client.getReceipt() != null && this.getReceipt() != null) {
            date1 = this.getReceipt().getDate();
            date2 = client.getReceipt().getDate();
        }
        return date1.compareTo(date2);
    }

    public void makeReceipt() {
        receipt = new Receipt();
    }
}
