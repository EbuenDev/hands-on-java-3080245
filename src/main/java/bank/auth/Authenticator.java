package bank.auth;

import javax.security.auth.login.LoginException;

import bank.constructor.Customer;

public class Authenticator {
  
  public static Customer login(String username, String password) throws LoginException {
    Customer customer = bank.model.CustomerModel.getCustomer(username);

    if (customer == null) {
        throw new LoginException("Customer not found");
    }

    if (password.equals(customer.getPassword())) {
        customer.setAuthenticated(true);  // Set the customer as authenticated.
        System.out.println("Login successful for user: " + customer.getUsername());
    }

    else throw new LoginException("Invalid password for user: " + customer.getUsername());
    return customer;

  }


  public static void logout(Customer customer) {
    customer.setAuthenticated(false);  // Set the customer as not authenticated.
    System.out.println("Logout successful for user: " + customer.getUsername());
  }
}
