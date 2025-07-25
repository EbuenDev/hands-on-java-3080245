package bank.constructor;

public class Customer {
    private int id;
    private String name;
    private String username;
    private String password;
    private int accountId;
    private Boolean authenticated;

    public Customer(int id,String name, String username, String password, int accountId) {
    
    this.id = id;
    this.name = name;
    this.username = username;
    this.password = password;
    this.accountId = accountId;
    this.authenticated = false;  // Initially, the customer is not logged in.
    
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isAuthenticated() {
        return authenticated;
    }
    
    public void setAuthenticated(Boolean authenticated) {
        this.authenticated = authenticated;
    }


}
