package Bank.account;
import Bank.transactions.TransactionLogger;

import java.util.ArrayList;

public class BankAccount {
    private double balance;
    private String accountID;


    // Constructor
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




