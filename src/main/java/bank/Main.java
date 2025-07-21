package bank;

import bank.constructor.Customer;
import static bank.model.CustomerModel.getCustomer;

public class Main {

  public static void main (String [] args) {
  
  Customer customer = getCustomer("Odelia Halbard");
  System.out.println(customer.getUsername());

  }

}
