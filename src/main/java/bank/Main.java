package bank;

import bank.constructor.Account;
import bank.constructor.Customer;
import static bank.model.AccountModel.getAccount;
import static bank.model.CustomerModel.getCustomer;

public class Main  {

  public static void main (String [] args) {
  
  Customer customer = getCustomer("Odelia Halbard");
  System.out.println(customer.getUsername());

  Account accountobj = getAccount(18780);
  System.out.println(accountobj.getBalance());

  }

}
