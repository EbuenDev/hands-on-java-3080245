package bank.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bank.constructor.Account;
import bank.database.Datasource;

public class AccountModel extends Datasource {

  public static Account getAccount(int accountId) {
      /*
       * The query should use a parameterized statement to prevent SQL injection.
       * Don't append raw userinput like String query = "SELECT * FROM accounts WHERE id = accountId"
       */ 
      String query = "SELECT * FROM accounts WHERE id = ?";
      Account account;
      try (Connection connection = connect();
      PreparedStatement prepareStatement = connection.prepareStatement(query)) {  // Call the connect method to establish a connection to the database.
        prepareStatement.setInt(1, accountId);
        try(ResultSet resultSet = prepareStatement.executeQuery()){
          account = new Account(
            resultSet.getInt("id"),
            resultSet.getString("type"),
            resultSet.getDouble("balance"));  // Create a new Account object with the data retrieved from the database.
        }

  }catch (SQLException e) {
      e.printStackTrace();  // If an exception occurs, print the stack trace for debugging.
      return null;  // Return null if an exception occurs.
    }
    return account;  // Return the account object.
  }
  
}
