package person;

import java.awt.*;

public class Client extends Person {
    private final int id;
    private Receipt receipt;

    public Client(String name, int age) {
        super(name, age);
        this.id = hashCode();
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
}
