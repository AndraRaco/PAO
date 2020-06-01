package functionCRUD;

import restaurant.Restaurant;
import restaurant.person.Client;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientsWithoutReceiptCRUD extends ConnectionCRUD {
    public ClientsWithoutReceiptCRUD() {
        super();
    }

    public void read(Restaurant restaurant) throws SQLException { // Clients that did not ordered yet
        // Clients that have receipt

        // SQL SELECT query
        String sql = "select * from clients";

        // Execute the query, and get a java resultSet
        ResultSet resultSet = statement.executeQuery(sql);

        ArrayList<Client> clients = restaurant.getClients();

        int k = 0;
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            Client newClient = new Client(name, age);
            clients.add(newClient);
            k++;
        }

        // Update id with the allocated hashCode
        for (int i = k - 1; i < restaurant.sizeOfClientsList(); i++) {
            int newId = restaurant.getClients().get(i).getId();
            String name = restaurant.getClients().get(i).getName();
            String sqlUpdateQuery = "UPDATE clients SET id=" + newId + " WHERE name=\"" + name + "\"";
            statement.executeUpdate(sqlUpdateQuery);
        }
    }
}
