package bank.account;

import bank.idtools.TransactionIDGenerator;

public class BankAccount {
    private double balance;
    private String accountID;
    private String userID;
    private boolean frozen = false;


    //Constructor
    public BankAccount(String accountID, String userID, double balance) {
        this.accountID = accountID;
        this.balance = balance;
        this.userID = userID;
    }
    // Constructor Wrapper
    public BankAccount(String accountID, String userID) {
        this.userID = userID;
        double balance = 0;
        this.accountID = accountID;
    }

    // getters
    public double getBalance(){
        return balance;
    }
    public String getAccountID(){
        return accountID;
    }
    public String getUserID(){
        return userID;
    }
    public boolean isFrozen(){
        return frozen;
    }
    // Setters
    public void setBalance(double newBalance){
        balance = newBalance;
    }

}




