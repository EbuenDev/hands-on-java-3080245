package bank.presenter;

import java.util.Scanner;

import javax.security.auth.login.LoginException;

import bank.constructor.Account;
import bank.constructor.Customer;

public class Menu {

  private Scanner scanner;

  public static void displayMainMenu() {
    System.out.println("Welcome to the Bank Application!");

    Menu menu = new Menu();
    menu.scanner = new Scanner(System.in);
    
    Customer customer = menu.AuthenticateCustomer();  // Authenticate the customer.
    if (customer != null && customer.isAuthenticated()) {
      Account account = bank.model.AccountModel.getAccount(customer.getAccountId());
      menu.showMenu(customer, account);
    }

  }

  private Customer AuthenticateCustomer() {
    System.out.println("Welcome to the Bank Application!");
    System.out.print("Username: ");
    String username = scanner.next();

    System.out.print("Password: ");
    String password = scanner.next();

    Customer customer =  null; 

    try {
        customer = bank.auth.Authenticator.login(username, password);
    } catch (LoginException e) {
      System.out.println("Login failed: " + e.getMessage());
    }
    return customer;
  }

  private void showMenu(Customer customerName, Account account) {

  }
}
