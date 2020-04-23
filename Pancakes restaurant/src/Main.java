import readWriteCSV.CSVReader;
import restaurant.Restaurant;

public class Main {
    public static void main(String[] args) {
        // Read all that has to be read
        Restaurant restaurant = new Restaurant("Andra's Pancakes Restaurant");
        System.out.println(restaurant.getName());

        CSVReader csvReader = CSVReader.getInstance();
        csvReader.readSetOfEmployees(restaurant);
        try {
            restaurant.showEmployeeList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        csvReader.readMenu(restaurant.getMenu());
        try {
            restaurant.showMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }

        csvReader.readOldClientsList(restaurant); // Clients that have already ordered
        csvReader.readClientsList(restaurant); // Clients that didn't ordered yet
        try {
            restaurant.showClientList();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
