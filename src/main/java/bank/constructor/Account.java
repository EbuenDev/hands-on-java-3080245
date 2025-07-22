package bank.constructor;

import bank.execption.AmountException;

public class Account {

    private int id;
    private String type;
    private double balance;


    public Account(int id, String type, double balance) {
    
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

    public String geType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void depositMoney(double amount) throws AmountException {
        if (amount < 100){
            throw new AmountException("The minimum deposit amount is 100.");
        }
        else if (amount > 10000) {
            throw new AmountException("The maximum deposit amount is 10,000.");
        }else{
            double newBalance = this.balance + amount;
            setBalance(newBalance);
        }

    }

    public void withdrawMoney(double amount) {
    
    }
}
