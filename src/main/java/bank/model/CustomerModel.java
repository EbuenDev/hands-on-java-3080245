package bank.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bank.constructor.Customer;
import bank.database.Datasource;

public class CustomerModel extends Datasource {

  public static Customer getCustomer(String name){
    
    
    // This method should retrieve a customer from the database based on the username.
    String query = "SELECT * FROM customers WHERE name = ?";  // Have a ? placeholder for the username to avoid SQL injection.
    Customer customer = null;  // Initialize the customer to null.
    // Make a structure try-catch resources to handle the database connection and query execution.
    try (Connection connection = connect();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {  // Call the connect method to establish a connection to the database.
      // First parameter is the number of the placeholder, second is the value to set which is the username.
      preparedStatement.setString(1, name);  
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
          customer = new Customer(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getString("username"),
            resultSet.getString("password"),
            resultSet.getInt("account_id"));  // Create a new Customer object with the data retrieved from the database, and a instance of a specific customer.
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();  
    }
    return customer;  // Return the customer object
  }
  
}
