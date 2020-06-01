# Pancakes restaurant Project

It is a programme written in Java designed to help with a Pancake Restaurant administration.

## Describing the code

It provides different methods and classes in order to update the restaurant's employees, clients, menu.

### Package and Classes
I. readWriteCSV (package)
1. CSVReader
2. CSVWriter 

II. restaurant (package) 
1. person (package) 
  * Person
    - Cliet
    - Employee
  * Receipt, numberDish is an ArrayList<Integer> in which we put the indexes of the products from menu.
  
2. product (package) <br>
  a. beverage (package)
    * Beverage
      - AlcoholicBeverage
      - NonalcoholicBeverages
  b. pancakes (package)
    * Ingredient
    * Pancake
3. Menu
4. Restaurant 
* Services
* Main
   
### Methods from Restaurant Class
1. Print methods
  * showEmployeeList
  * showClientList
  * showMenu
  * printProductsFromReceipt<br>
2. clientsDidNotOrdere, returns a list of indexes of the clients that have not ordered
3. actualizeMoneyEarned, after a new order we add the Total Order to the variable, moneyEarned
4. waiter, returns a waiter from the employee list 
5. newClient, reads from System.in the name and the age of a new Client and adds it in the list of clients
6. takeOrder, a waiter takes the order from the new Client
7. closeScanner
8. sortClientsAfterDate, date is in class Receipt

### Methods from Services Class
1. printListOfActions, prints the list of the services of the restaurant
2. readChoice, reads from System.in the choice from the list of actions
3. nameOfTheRestaurant, prints the name of the restaurant
4. readAllDataFromCSV, reads the List of Employees, the Menu, the List of Clients that have ordered and the ones that have not
5. takeOrderFromNewClients, takes orders from new clients
6. welcomeNewClientreads from System.in the name and the age of a new Client and adds it in the list of clients
7. sortClientsAfterDate, sorts clients after date
8. oneOfTheWaiters, prints the information of one of the waiters
9. printWhatOrderedClientWithIndex
10. showClientsList
11. showEmployeesList
12. showTotalMoneyEarned

### Main
List of services: 
1. Show The Name of the Restaurant.
2. Show Menu.
3. Show The List of Employees.
4. Show The List of Clients.
5. Show Total Money Earned.
6. Show what ordered client with the index you enter.
7. Information about one of the waiters.
8. Sort Clients after Date.
9. Welcome new Client and take their information.
10. Take the orders from the new Clients.
11. Close The Application.


Requirement: https://github.com/constantin-voinea/java-fundamentals/blob/master/tema_proiect.txt

