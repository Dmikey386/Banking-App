package Bank.user;

import Bank.transactions.TransactionLogger;
import Bank.transactions.TransactionRequest;

import java.util.HashMap;

public class User {
    private String userID;
    private HashMap<String, Double> userAccMap = new HashMap<>(); // Key = accountID, value = balance
    private TransactionLogger transactionManager; // store transactions by user

    //User Constructor
    public User(String userID){
        this.userID = userID;
    }

    //get user ID
    public String getUserID() {
        return userID;
    }
    public HashMap<String, Double> getUserAccMap() {
        return userAccMap;
    }

    // Add account to user account Map
    public void addAccount(String accountID, double accountBalance){
        userAccMap.put(accountID, accountBalance);
    }


    // Request Transaction
    public TransactionRequest createTransactionRequest(String[] accounts, double amount, int transactionType){
        TransactionRequest request = new TransactionRequest.Builder()
                .user(this)
                .accountIDs(accounts)
                .amount(amount)
                .transactionType(transactionType)
                .status(false)
                .build();

        return request;
    }



}
