package Bank.account;
import Bank.transactions.TransactionLogger;

import java.util.ArrayList;

public class BankAccount {
    private double balance;
    private String accountID;
    private TransactionLogger transactionLog = new TransactionLogger(); // Store transactions by account

    // Constructor
    public BankAccount(String accountNumber) {
        double balance = 0;
        this.accountID = accountID;
    }

    // getters
    public double getBalance(){
        return balance;
    }
    public String getAccountNumber(){
        return accountID;
    }
    public TransactionLogger getTransactionLog(){
        return transactionLog;
    }

    // Setters
    public void setBalance(double newBalance){
        balance = newBalance;
    }
    public void logTransaction(String transactionID, ArrayList<Object> transactionRequest) {
        transactionLog.logTransaction(transactionID, transactionRequest);
    }
}




