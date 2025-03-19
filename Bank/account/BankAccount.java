package Bank.account;
import java.util.ArrayList;

public class BankAccount {
    private double balance;
    private int accountNumber;
    private TransactionLogger transactionLog = new TransactionLogger(); // Store transactions by account

    // Constructor
    public BankAccount(int accountNumber) {
        double balance = 0;
        this.accountNumber = accountNumber;
    }

    // getters
    public double getBalance(){
        return balance;
    }
    public int getAccountNumber(){
        return accountNumber;
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




