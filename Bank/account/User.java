package Bank.account;
import Bank.core.transactions.Transaction;

import java.util.Random;
import java.util.HashMap;
import java.util.ArrayList;

public class User {
    private int userID;
    private HashMap<Integer, Double> userAccMap = new HashMap<>(); // Key = accountID, value = balance
    private double totalBalance;
    private TransactionManager transactionManager; // store transactions by user

    //User Constructor
    public User(int userID){
        this.userID = userID;
        totalBalance = 0;
    }

    // Request Transaction
    public TransactionRequest createTransactionRequest(int[] accounts, double amount, int transactionType){
        TransactionRequest request = new TransactionRequest.Builder()
                .user(this)
                .accountIDs(accounts)
                .amount(amount)
                .transactionType(transactionType)
                .status(false)
                .build();

        return request;
    }



    // Open new account
    public int openAccount(String accountType) {
        Random rand = new Random();

        // Check for valid account number in database
        int accountNumber = rand.nextInt(1000);

        // Make account
        switch (accountType) {
            case "Checking":
                CheckingAccount newChecking = new CheckingAccount(accountNumber);
                userAccMap.put(accountNumber, newChecking.getBalance());
                break;
            case "Savings":
                SavingsAccount newSavings = new SavingsAccount(accountNumber);
                userAccMap.put(accountNumber, newSavings.getBalance());
                break;
            default: // would not occur if there was a button to pick
                System.out.println("Invalid account type");
                break;
        }
        return accountNumber;
    }
}
