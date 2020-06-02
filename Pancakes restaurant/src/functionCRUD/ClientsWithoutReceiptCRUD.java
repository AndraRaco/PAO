package functionCRUD;

import restaurant.Restaurant;
import restaurant.person.Client;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

    public void create(Restaurant restaurant, Client newClient) {
        // Add a new client with receipt
        String sql = "INSERT INTO clients (id, name, age) VALUES (?, ?, ?)";

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

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new client without receipt was inserted successfully!");
                // Add new client without receipt to the client list
                restaurant.getClients().add(newClient);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(Restaurant restaurant, Client client) {
        String nameToDelete = client.getName();
        String sql = "DELETE FROM clients WHERE name=\"" + nameToDelete + "\"";
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

    public void updateAge(Restaurant restaurant, int index, int newAge)
    {
        String name = restaurant.getClients().get(index).getName();
        Client clientToBeUpdated = restaurant.getClients().get(index);

        String sqlUpdateQuery = "UPDATE clients SET age=" + newAge + " WHERE name=\"" + name + "\"";
        try {
            statement.executeUpdate(sqlUpdateQuery);
            clientToBeUpdated.setAge(newAge);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Client age wasn't updated.");
        }
    }
}
