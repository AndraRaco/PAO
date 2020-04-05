import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant=new Restaurant("Andra's Restaurant");
        restaurant.showMenu();
        System.out.println();

        restaurant.showEmployeeList();
        System.out.println();

        restaurant.showClientList();
        System.out.println();

<<<<<<< HEAD
=======
        // New Client in the restaurant
        Client newClient1 = restaurant.newClient();
        restaurant.takeOrder(newClient1);

        Client newClient2 = restaurant.newClient();
        restaurant.takeOrder(newClient2);
        restaurant.closeScanner();

        System.out.println("\nTotal money earned: " + restaurant.getMoneyEarned());// Total money earned
>>>>>>> parent of 87edeae... takeOrder usage moved in newClient


    }
}
