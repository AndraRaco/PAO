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



    }
}
