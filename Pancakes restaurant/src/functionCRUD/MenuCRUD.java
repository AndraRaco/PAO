package functionCRUD;

import restaurant.Menu;
import restaurant.Restaurant;
import restaurant.product.Product;
import restaurant.product.beverage.AlcoholicBeverage;
import restaurant.product.beverage.Beverage;
import restaurant.product.beverage.NonalcoholicBeverages;
import restaurant.product.pancakes.Ingredient;
import restaurant.product.pancakes.Pancake;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class MenuCRUD extends ConnectionCRUD {

    public MenuCRUD() {
        super();
    }

    public void read(Menu menuRestaurant) throws SQLException {

        // SQL SELECT query
        String sql = "select * from menu";

        // Execute the query, and get a java resultSet
        ResultSet resultSet = statement.executeQuery(sql);

        ArrayList<Product> menu = menuRestaurant.getMenu();
        int numberProducts = 0;

        // Iterate through the java resultSet
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            double alcoholMeasurements = resultSet.getDouble("alcohol_measurements");
            String ingredients = resultSet.getString("ingredients");
            String name = resultSet.getString("name");
            int numberIngredients = resultSet.getInt("number_ingredients");
            double price = resultSet.getDouble("price");
            String product = resultSet.getString("product");
            String productType = resultSet.getString("product_type");
            double weight = resultSet.getDouble("weight");

            numberProducts++;
            if (product.equals("drink")) {
                if (productType.equals("nonalcoholic")) {
                    Product pr = new NonalcoholicBeverages(price, name, weight);
                    menu.add(pr);
                } else if (productType.equals("alcoholic")) {
                    Product pr = new AlcoholicBeverage(price, name, weight, alcoholMeasurements);
                    menu.add(pr);
                }
            } else if (product.equals("pancake")) {
                Product pr = new Pancake(name, price, productType, weight, numberIngredients);
                String[] strings = ingredients.split(",");
                for (int j = 0; j < numberIngredients; j++) {
                    Ingredient newIngredient = new Ingredient(strings[j * 2], Double.parseDouble(strings[j * 2 + 1]));
                    ((Pancake) pr).add(newIngredient);
                }
                menu.add(pr);
            }
        }
        menuRestaurant.setNumberProducts(numberProducts);
    }

    public Vector<Vector<Object>> readForGUI() throws SQLException {

        // SQL SELECT query
        String sql = "select * from menu";

        // Execute the query, and get a java resultSet
        ResultSet resultSet = statement.executeQuery(sql);

        // Matrix
        Vector<Vector<Object>> menu = new Vector<Vector<Object>>();

        // Iterate through the java resultSet
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            double price = resultSet.getDouble("price");
            String product = resultSet.getString("product");
            String productType = resultSet.getString("product_type");
            double weight = resultSet.getDouble("weight");

            Vector<Object> aux = new Vector<Object>();
            aux.add(product);
            aux.add(productType);
            aux.add(name);
            aux.add(weight);
            aux.add(price);

            menu.add(aux);
        }
        return menu;

    }


    public void create(Menu menu, Product newProduct) throws SQLException {
        int rowsInserted;

        // Drink or pancake
        if (newProduct instanceof Beverage) {
            // Type of Beverage, alcoholic or nonalcoholic
            if (newProduct instanceof NonalcoholicBeverages) {
                String sql = "INSERT INTO menu (product, product_type, name, price, weight) VALUES (?, ?, ?, ?, ?)";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "drink");
                preparedStatement.setString(2, "nonalcoholic");
                preparedStatement.setString(3, newProduct.getName());
                preparedStatement.setDouble(4, newProduct.getPrice());
                preparedStatement.setDouble(5, ((NonalcoholicBeverages) newProduct).getWeightLiters());

                rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new product was inserted successfully!");
                    // Inserting in the menu list
                    menu.addProduct(newProduct);
                }
            } else if (newProduct instanceof AlcoholicBeverage) {
                String sql = "INSERT INTO menu (product, product_type, name, price, weight, alcohol_measurements) VALUES (?, ?, ?, ?, ?, ?)";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "drink");
                preparedStatement.setString(2, "nonalcoholic");
                preparedStatement.setString(3, newProduct.getName());
                preparedStatement.setDouble(4, newProduct.getPrice());
                preparedStatement.setDouble(5, ((AlcoholicBeverage) newProduct).getWeightLiters());
                preparedStatement.setDouble(6, ((AlcoholicBeverage) newProduct).getAlcoholMeasurements());

                rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new product was inserted successfully!");
                    // Inserting in the menu list
                    menu.addProduct(newProduct);
                }
            }
        } else if (newProduct instanceof Pancake) {
            String sql = "INSERT INTO menu (product, product_type, name, price, weight, number_ingredients, ingredients) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "pancakes");
            if (((Pancake) newProduct).getType().equals("sweet")) {
                preparedStatement.setString(2, "sweet");
            } else {
                preparedStatement.setString(2, "salty");
            }
            preparedStatement.setString(3, newProduct.getName());
            preparedStatement.setDouble(4, newProduct.getPrice());
            preparedStatement.setDouble(5, (((Pancake) newProduct).getWeight()));
            preparedStatement.setInt(6, (((Pancake) newProduct).getNumberIngredients()));
            preparedStatement.setString(7, ((Pancake) newProduct).ingredientsAndGrams());

            rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new product was inserted successfully!");
                // Inserting in the menu list
                menu.addProduct(newProduct);
            }
        }
    }

    public void updatePrice(Restaurant restaurant, int index, double price) {
        String name = restaurant.getMenu().getMenu().get(index).getName();
        restaurant.getMenu().getMenu().get(index).setPrice(price);
        String sqlUpdateQuery = "UPDATE menu SET price=" + price + " WHERE name=\"" + name + "\"";
        try {
            statement.executeUpdate(sqlUpdateQuery);
        } catch (SQLException throwables) {
            System.out.println("The price wasn't set.");
            throwables.printStackTrace();
        }
    }

    public void delete(Menu menu, int index) {
        if (index >= 0 && index < menu.getNumberProducts()) {
            String nameToDelete = menu.getMenu().get(index).getName();

            String sql = "DELETE FROM menu WHERE name=\"" + nameToDelete + "\"";
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
                System.out.println("A product from menu was deleted successfully!");
            }
        } else {
            System.out.println("The menu is empty or the index is to big.");
        }
    }
}
