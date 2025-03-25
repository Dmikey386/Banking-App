package Bank.user;

import Bank.transactions.TransactionLogger;
import Bank.transactions.TransactionRequest;

import java.util.Map;
import java.util.HashMap;

public class User {
    private String userID;
    private Map<String, Double> userAccMap; // Key = accountID, value = balance

    //User Constructor
    public User(String userID, HashMap<String, Double> userAccMap) {
        this.userAccMap = userAccMap;
        this.userID = userID;
    }
    // User Constructor Wrapper
    public User(String userID) {
        this.userID = userID;
        userAccMap = new HashMap<>();
    }

    //get user ID
    public String getUserID() {
        return userID;
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
