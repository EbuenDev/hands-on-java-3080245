package bank;

public class Main {

  public static void main (String [] args) {
    // make a connection to the database
    
    Datasource.connect();   // Since the connect method is static, we can call it directly using the class name.

  }

}
