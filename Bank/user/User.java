package Bank.user;

import Bank.singleTransactions.TransactionRequest;

import java.util.Map;
import java.util.HashMap;

public class User {
    private String userID;
    public Map<String, Double> userAccMap; // Key = accountID, value = balance

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

    public boolean verifyAccount(String accountID){
        return userAccMap.containsKey(accountID);
    }


    // Request Transaction
    public TransactionRequest createTransactionRequest(String[] accounts, double amount, int transactionType){
        TransactionRequest request = new TransactionRequest.Builder()
                .userID(this.getUserID())
                .accountIDs(accounts)
                .amount(amount)
                .transactionType(transactionType)
                .status(false)
                .build();

        return request;
    }



}
