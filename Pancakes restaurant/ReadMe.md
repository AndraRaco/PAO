# Pancakes restaurant Project

It is a programme written in Java designed to help with a Pancake restaurant.Restaurant administration.

## Describing the code

It provides different methods and classes in order to update the restaurant's employees, clients, menu.

### Package and Classes
1. Person (package) <br>
  * Person
    - Cliet
    - Employee
  * Receipt, numberDish is an ArrayList<Integer> in which we put the indexes of the products from menu.
  
2. Product (package) <br>
  a. beverage (package)
    * Beverage
      - AlcoholicBeverage
      - NonalcoholicBeverages
  b. pancakes (package)
    * Ingredient
    * Pancake
* restaurant.Menu
* restaurant.Restaurant 
* Main
   
### Methods from restaurant.Restaurant Class
1. Read methods:
  * readEmployeeList
  * readClientList
  * readMenu
  
2. Print methods
  * showEmployeeList
  * showClientList
  * showMenu
  * printProductsFromReceipt<br>
  
3. actualizeMoneyEarned, after a new order we add the Total Order to the variable, moneyEarned.
4. waiter, returns a waiter from the employee list 
5. newClient, reads from System.in the name and the age of a new Client and adds it in the list of clients.
6. takeOrder, a waiter takes the order from the new Client
7. closeScanner
8. sortClientsAfterDate, date is in class Receipt

Requirement: https://github.com/constantin-voinea/java-fundamentals/blob/master/tema_proiect.txt

