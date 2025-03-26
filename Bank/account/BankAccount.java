package Bank.account;
import Bank.transactions.TransactionLogger;

import java.util.ArrayList;

public class BankAccount {
    private double balance;
    private String accountID;

    public BankAccount(String accountID, double balance) {
        this.accountID = accountID;
        this.balance = balance;
    }
    // Constructor Wrapper
    public BankAccount(String accountID) {
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
    // Setters
    public void setBalance(double newBalance){
        balance = newBalance;
    }

}




