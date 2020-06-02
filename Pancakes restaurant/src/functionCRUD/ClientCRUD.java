package functionCRUD;

import restaurant.Menu;
import restaurant.Restaurant;
import restaurant.person.Client;
import restaurant.person.Receipt;

import javax.xml.crypto.Data;
import java.io.*;
import java.sql.PreparedStatement;
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
                // Update receipt id with the allocated hashcode
                int receiptID = restaurant.getClients().get(i).getReceipt().getId();
                String sqlUpdateQuery2 = "UPDATE clients_with_receipt SET receipt_id=" + receiptID + " WHERE name=\"" + name + "\"";
                try {
                    statement.executeUpdate(sqlUpdateQuery2);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void create(Restaurant restaurant, Client newClient) {
        // Add a new client with receipt
        String sql = "INSERT INTO clients_with_receipt (id, name, age, date, receipt_id, number_products, products) VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            preparedStatement.setInt(1, newClient.getId());
            preparedStatement.setString(2, newClient.getName());
            preparedStatement.setInt(3, newClient.getAge());
            Date date = newClient.getReceipt().getDate();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String newDate = formatter.format(date);
            preparedStatement.setDate(4, java.sql.Date.valueOf(newDate));
            preparedStatement.setInt(5, newClient.getReceipt().getId());
            preparedStatement.setInt(6, newClient.getReceipt().getNumberOfDishes());
            preparedStatement.setString(7, newClient.getReceipt().indexProductListToString());


            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new client with receipt was inserted successfully!");
                // Add new client with receipt to the client list
                restaurant.getClients().add(newClient);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(Restaurant restaurant, Client client) {
        String nameToDelete = client.getName();
        String sql = "DELETE FROM clients_with_receipt WHERE name=\"" + nameToDelete + "\"";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        int rowsDeleted = 0;
        try {
            rowsDeleted = preparedStatement.executeUpdate();
            // Delete client from the list of Clients
            restaurant.getClients().remove(client);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("The client wasn't deleted!");
        }
        if (rowsDeleted > 0) {
            System.out.println("A client was deleted successfully!");
        }
    }

}
