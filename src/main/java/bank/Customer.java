package bank;

public class Customer {
  private int id;
  private String username;
  private String password;
  private int accountId;

  public Customer(int id, String username, String password, int accountId) {
    setId(id);
    setUsername(username);
    setPassword(password);
    setAccountId(accountId);
    
  }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

  
}
