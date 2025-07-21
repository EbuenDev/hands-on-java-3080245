package bank.database;

import java.sql.Connection;
import java.sql.DriverManager;
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
       System.out.println("Connection to the database established successfully.");

     }catch (SQLException e) {
       // If an exception occurs, print the stack trace for debugging.
       e.printStackTrace();
     }
     
     return connection;  // Return the established connection.

  }

}
