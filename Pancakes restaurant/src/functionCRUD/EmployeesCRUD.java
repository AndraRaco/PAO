package functionCRUD;

import restaurant.Restaurant;
import restaurant.person.Employee;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

public class EmployeesCRUD extends ConnectionCRUD {

    public EmployeesCRUD() {
        super();
    }

    public void read(Restaurant restaurant) throws SQLException {

        // SQL SELECT query
        String sql = "select * from employees";

        // Execute the query, and get a java resultSet
        ResultSet resultSet = statement.executeQuery(sql);

        Set<Employee> employees = restaurant.getEmployees();

        // Iterate through the java resultSet
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int age = resultSet.getInt("age");
            String name = resultSet.getString("name");
            String job = resultSet.getString("job_title");

            // Add the new employee to the Set
            Employee newEmployee = new Employee(id, name, age, job);
            employees.add(newEmployee);
        }

    }

    public void create(Restaurant restaurant, Employee employee)
    {
        // Add a new employee
        String sql = "INSERT INTO menu (name, age, job_title) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        preparedStatement.setString(1, "drink");

    }
}
