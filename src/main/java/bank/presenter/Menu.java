package bank.presenter;

import java.util.Scanner;

import javax.security.auth.login.LoginException;

import bank.constructor.Account;
import bank.constructor.Customer;
import bank.execption.AmountException;

public class Menu {

  private Scanner scanner = new Scanner(System.in);

  public static void displayMainMenu() {

    Menu menu = new Menu();  // Create an instance of the Menu class to access the non static methods.
    menu.authenticateCustomer();

    System.out.println("===================================");
    System.out.println("Welcome to the Bank Application!");
    Customer customer = menu.authenticateCustomer();  // Authenticate the customer.


    if (customer != null && customer.isAuthenticated()) {
      Account account = bank.model.AccountModel.getAccount(customer.getAccountId());
      menu.showMenu(customer, account);
    }

  }

  private  Customer authenticateCustomer() {
    System.out.println("Please log in to continue.");
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

  private void showMenu(Customer customerName, Account account) throws AmountException {


    int selection = 0;
    while (selection != 5 && customerName.isAuthenticated()) {
      System.out.println("===================================");
      System.out.println("Welcome " + customerName.getUsername() + "!");
      System.out.println("1. View Account Details");
      System.out.println("2. Deposit Money");
      System.out.println("3. Withdraw Money");
      System.out.println("4. Logout");
      System.out.println("5. Exit");
      System.out.print("Please select an option: ");

      selection = scanner.nextInt();
      double amount = 0;

      switch (selection) {
        case 1:
          System.out.println("Account ID: " + account.getId());
          System.out.println("Account Type: " + account.geType());
          System.out.println("Account Balance: $" + account.getBalance());
          System.out.println("===================================");
          break;
        case 2:
          System.out.print("Enter amount to deposit: $");
          amount = scanner.nextDouble();
          account.depositMoney(amount);
          break;
        case 3:
          System.out.print("Enter amount to withdraw: $");
          amount = scanner.nextDouble();
          account.withdrawMoney(amount);
          break;
        case 4:
          bank.auth.Authenticator.logout(customerName);
          return; // Exit the menu after logout
        case 5:
          System.out.println("Exiting the application. Goodbye!");
          return; // Exit the application
        default:
          System.out.println("Invalid selection, please try again.");
      }
    }
  }

}
