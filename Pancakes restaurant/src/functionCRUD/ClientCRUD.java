package functionCRUD;

import restaurant.Menu;
import restaurant.Restaurant;
import restaurant.person.Client;
import restaurant.person.Receipt;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientCRUD extends ConnectionCRUD {
    public ClientCRUD() {
        super();
    }

    public void read(Restaurant restaurant) throws SQLException {
        // Clients that have receipt

        // SQL SELECT query
        String sql = "select * from clients_with_receipt";

        // Execute the query, and get a java resultSet
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            Date date = resultSet.getDate("date");
            int numberOfDishes = resultSet.getInt("number_products");
            Receipt receipt = new Receipt(date, numberOfDishes);
            Menu menu = restaurant.getMenu();
            String products = resultSet.getString("products");
            String[] strings = products.split(",");

            for (int i = 0; i < numberOfDishes; i++) {
                int index = Integer.parseInt(strings[i]) - 1;
                receipt.addDish(index);
                double priceDish = menu.priceOfAProduct(index);
                receipt.addPriceOfAProductToTotalOrder(priceDish);
            }
            Client newClient = new Client(name, age, receipt);

            try {
                restaurant.actualizeMoneyEarned(newClient.receiptTotalOrder());
            } catch (Exception e) {
                e.printStackTrace();
            }

            restaurant.addClient(newClient);
        }

    }

    public void updateIDAndReceiptID(Restaurant restaurant) {
        for (int i = 0; i < restaurant.sizeOfClientsList(); i++) {
            // Update id with the allocated hashCode
            int newId = restaurant.getClients().get(i).getId();
            String name = restaurant.getClients().get(i).getName();
            String sqlUpdateQuery = "UPDATE clients_with_receipt SET id=" + newId + " WHERE name=\"" + name + "\"";
            try {
                statement.executeUpdate(sqlUpdateQuery);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            // Update receipt id with the allocated hashcode
            int receiptID = restaurant.getClients().get(i).getReceipt().getId();
            String sqlUpdateQuery2 = "UPDATE clients_with_receipt SET receipt_id=" + receiptID + " WHERE name=\"" + name + "\"";
            try {
                statement.executeUpdate(sqlUpdateQuery2);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
