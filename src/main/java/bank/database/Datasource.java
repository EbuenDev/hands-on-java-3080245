package bank.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Datasource {

  public static Connection connect() {
    /*
     * This method should establish a connection to the database.
     * Now we need to declare the path to the database file.
     */

    String database_file = "jdbc:sqlite:resources/bank.db";  // this is the path to the database file.
    Connection connection = null;  // Setting the connection to null initially.
    
    try {
    // Attempt to establish a connection to the database.
    connection = DriverManager.getConnection(database_file);

    }catch (SQLException e) {
       // If an exception occurs, print the stack trace for debugging.
      e.printStackTrace();
    }
    
     return connection;  // Return the established connection.

  }


  public static void updateAccountBalance(int accountId, double balance) {
    // This method should update the account balance in the database.
    // Implementation will be added later.
    String query = "UPDATE accounts SET balance = ? WHERE id = ?";

    Connection connection = connect();
    try(PreparedStatement statement = connection.prepareStatement(query);
    ){
    statement.setDouble(1, balance);
    statement.setInt(2, accountId);

    statement.executeUpdate();  // Execute the update statement to change the balance in the database.
    
    }catch (SQLException e){
      e.printStackTrace();
    }

    }
  }

