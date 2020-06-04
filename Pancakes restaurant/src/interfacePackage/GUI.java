package interfacePackage;

import functionCRUD.ClientCRUD;
import functionCRUD.ClientsWithoutReceiptCRUD;
import functionCRUD.EmployeesCRUD;
import functionCRUD.MenuCRUD;
import restaurant.person.Client;
import servicesPackage.Services;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class GUI {
    private int count = 0;
    private JLabel label;
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel servicesPanel;
    public String SERVICES_PANEL = "Services Panel";
    private JPanel resultPanel;
    public String RESULT_PANEL = "Result Panel";
    private CardLayout cardLayout;
    private Services services;
    int layoutVisible; // 1 - Services Panel 2 - Result Panel

    public GUI() {
        // Initializations
        frame = new JFrame();
        mainPanel = new JPanel();
        servicesPanel = new JPanel();
        resultPanel = new JPanel();
        services = new Services("Andra's Pancakes Restaurant");

        // JFrame Methods
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Main Panel with CardLayout
        mainPanel.setPreferredSize(new Dimension(500, 200));
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);


        // ServicesPanel
        // Set the border and the layout as a table 5x2
        servicesPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        servicesPanel.setLayout(new GridLayout(5, 2));

        // Read all data from database: Menu, Employees, Clients with receipt and new Clients
        try {
            services.readAllDataFromDatabase();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Reading data from database did not work.");
        }

        // Create List of services and buttons to access them
        JLabel label1 = new JLabel("Show clients that didn't order yet.");
        JButton button1 = new JButton("Click me!");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) { // Read
                switchPanels();
                resultPanel.removeAll();
                ClientsWithoutReceiptCRUD clientCRUD = services.getNewClientCRUD();
                Vector<Vector<Object>> data = null;

                try {
                    data = clientCRUD.readForGUI();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    System.out.println("Couldn't read clients from database.");
                }
                Vector<Object> columnNames = new Vector<Object>();
                columnNames.add("name");
                columnNames.add("age");

                JTable table = new JTable(data, columnNames);

                resultPanel.add(table);
            }
        });
        servicesPanel.add(label1);
        servicesPanel.add(button1);

        JLabel label2 = new JLabel("Show menu");
        JButton button2 = new JButton("Click me!");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                switchPanels();
                resultPanel.removeAll();
                MenuCRUD menuCRUD = services.getMenuCRUD();
                try {
                    Vector<Vector<Object>> data = menuCRUD.readForGUI();

                    Vector<Object> columnNames = new Vector<Object>();
                    columnNames.add("product");
                    columnNames.add("product type");
                    columnNames.add("name");
                    columnNames.add("weight");
                    columnNames.add("price");

                    JTable table = new JTable(data, columnNames);

                    resultPanel.add(table);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    System.out.println("Couldn't read menu from database.");
                }
            }
        });
        servicesPanel.add(label2);
        servicesPanel.add(button2);

        JLabel label3 = new JLabel("Show employees");
        JButton button3 = new JButton("Click me!");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                switchPanels();
                resultPanel.removeAll();
                EmployeesCRUD employeesCRUD = services.getEmCRUD();
                try {
                    Vector<Vector<Object>> data = employeesCRUD.readForGUI();
                    Vector<Object> columnNames = new Vector<Object>();
                    columnNames.add("name");
                    columnNames.add("age");
                    columnNames.add("job title");

                    JTable table = new JTable(data, columnNames);

                    resultPanel.add(table);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    System.out.println("Couldn't read employees from database");
                }
            }
        });
        servicesPanel.add(label3);
        servicesPanel.add(button3);

        JLabel label4 = new JLabel("Show clients that have ordered.");
        JButton button4 = new JButton("Click me!");
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                switchPanels();
                resultPanel.removeAll();
                ClientCRUD clientCRUD = services.getClientCRUD();
                Vector<Vector<Object>> data = null;
                try {
                    data = clientCRUD.readForGUI();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    System.out.println("Couldn't read clients from database.");
                }
                Vector<Object> columnNames = new Vector<Object>();
                columnNames.add("name");
                columnNames.add("age");
                columnNames.add("date");

                JTable table = new JTable(data, columnNames);

                resultPanel.add(table);
            }
        });
        servicesPanel.add(label4);
        servicesPanel.add(button4);

        JLabel label5 = new JLabel("Take client information");
        JButton button5 = new JButton("Click me!");
        button5.setPreferredSize(new Dimension(50, 50));
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                switchPanels();
                resultPanel.removeAll();

                // Set the border and the layout as a table 5x2
                resultPanel.setLayout(new GridLayout(3, 2));

                JLabel textLabelName = new JLabel("Name:");
                resultPanel.add(textLabelName);
                JTextField textFieldName = new JTextField();
                resultPanel.add(textFieldName);

                JLabel textLabelAge = new JLabel("Age:");
                resultPanel.add(textLabelAge);
                JTextField textFieldAge = new JTextField();
                resultPanel.add(textFieldAge);

                JButton buttonSave = new JButton("Save");
                buttonSave.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        ClientsWithoutReceiptCRUD clientsCRUD = services.getNewClientCRUD();

                        // Get data
                        String name = textFieldName.getText();
                        int age = Integer.parseInt(textFieldAge.getText());

                        // Add new client in database
                        Client newClient = new Client(name, age);
                        clientsCRUD.create(services.getRestaurant(), newClient);
                    }
                });
                JLabel empty = new JLabel();
                resultPanel.add(empty);
                resultPanel.add(buttonSave);
            }
        });
        servicesPanel.add(label5);
        servicesPanel.add(button5);

        // Add panels to the main panel
        mainPanel.add(servicesPanel, SERVICES_PANEL);
        mainPanel.add(resultPanel, RESULT_PANEL);
        showServicesPanel(); // The panel we see when we open the app

        // Button to switch between panels
        JButton button = new JButton("Switch Panels");
        button.addActionListener(e -> switchPanels());

        frame.setLayout(new BorderLayout());
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle("Restaurant App");
        frame.pack();
        frame.setVisible(true);
    }

    void showServicesPanel() {
        cardLayout.show(mainPanel, SERVICES_PANEL);
        layoutVisible = 1;
    }

    void showResultPanel() {
        cardLayout.show(mainPanel, RESULT_PANEL);
        layoutVisible = 2;
    }

    void switchPanels() {
        if (layoutVisible == 1)
            showResultPanel();
        else
            showServicesPanel();
    }

    public static void main(String[] args) {
        new GUI();
    }
}
