package bank;

public class Account {

  private int id;
  private double balance;
  private String accountType;

  public Account(int id, double balance, String accountType) {
    
    setId(id);
    setBalance(balance);
    setAccountType(accountType);

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
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
