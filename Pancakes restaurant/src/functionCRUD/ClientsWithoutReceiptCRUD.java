package functionCRUD;

import restaurant.Restaurant;
import restaurant.person.Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

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
    }

    public Vector<Vector<Object>> readForGUI() throws SQLException { // Clients that did not ordered yet
        // Clients that have receipt

        // SQL SELECT query
        String sql = "select * from clients";

        // Execute the query, and get a java resultSet
        ResultSet resultSet = statement.executeQuery(sql);

        // Matrix
        Vector<Vector<Object>> clients = new Vector<Vector<Object>>();

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");

            Vector<Object> aux = new Vector<Object>();
            aux.add(name);
            aux.add(age);
            clients.add(aux);
        }
        return clients;
    }

    public void create(Restaurant restaurant, Client newClient) {
        // Add a new client with receipt
        String sql = "INSERT INTO clients (name, age) VALUES ( ?, ?)";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
//            preparedStatement.setInt(1, newClient.getId());
            preparedStatement.setString(1, newClient.getName());
            preparedStatement.setInt(2, newClient.getAge());

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

//    public void create(Restaurant restaurant, Client newClient) {
//        // Add a new client with receipt
//        String sql = "INSERT INTO clients (id, name, age) VALUES (?, ?, ?)";
//
//        PreparedStatement preparedStatement = null;
//        try {
//            preparedStatement = connection.prepareStatement(sql);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        try {
//            preparedStatement.setInt(1, newClient.getId());
//            preparedStatement.setString(2, newClient.getName());
//            preparedStatement.setInt(3, newClient.getAge());
//
//            int rowsInserted = preparedStatement.executeUpdate();
//            if (rowsInserted > 0) {
//                System.out.println("A new client without receipt was inserted successfully!");
//                // Add new client without receipt to the client list
//                restaurant.getClients().add(newClient);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }

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

    public void updateAge(Restaurant restaurant, int index, int newAge) {
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
