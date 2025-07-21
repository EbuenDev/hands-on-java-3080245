package bank.constructor;

public class Account {

  private int id;
  private String type;
  private double balance;


  public Account(int id, String type,double balance) {
    
    this.id = id;
    this.type = type;
    this.balance = balance;

  }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return type;
    }

    public void setAccountType(String type) {
        this.type = type;
    }
}
