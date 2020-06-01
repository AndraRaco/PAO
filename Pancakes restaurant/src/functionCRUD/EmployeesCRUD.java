package functionCRUD;

import restaurant.Restaurant;
import restaurant.person.Employee;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
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
            int age = resultSet.getInt("age");
            String name = resultSet.getString("name");
            String job = resultSet.getString("job_title");

            // Add the new employee to the Set
            Employee newEmployee = new Employee(name, age, job);
            employees.add(newEmployee);
        }

    }

    public void create(Restaurant restaurant, Employee employee) {
        // Add a new employee
        String sql = "INSERT INTO employees (name, age, job_title) VALUES (?, ?, ?)";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setInt(2, employee.getAge());
            preparedStatement.setString(3, employee.getJobName());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new employee was inserted successfully!");
                // Add new employee to the employee list
                restaurant.getEmployees().add(employee);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateAge(Restaurant restaurant, Employee newEmployee, int newAge) {
        // Edit age in the set of Employees
        String name = null;
        for (Iterator<Employee> it = restaurant.getEmployees().iterator(); it.hasNext(); ) {
            Employee f = it.next();
            if (f.equals(newEmployee)) {
                f.setAge(newAge);
                name = f.getName();
            }
        }

        String sqlUpdateQuery = "UPDATE employees SET age=" + newAge + " WHERE name=\"" + name + "\"";
        try {
            statement.executeUpdate(sqlUpdateQuery);
        } catch (SQLException throwables) {
            System.out.println("The new age wasn't set.");
            throwables.printStackTrace();
        }
    }

    public void delete(Restaurant restaurant, Employee employee) {
        // Delete employee from the set of Employees
        String nameToDelete = employee.getName();
        restaurant.getEmployees().remove(employee);

        String sql = "DELETE FROM employees WHERE name=\"" + nameToDelete + "\"";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        int rowsDeleted = 0;
        try {
            rowsDeleted = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (rowsDeleted > 0) {
            System.out.println("A employee was deleted successfully!");
        }
    }
}
