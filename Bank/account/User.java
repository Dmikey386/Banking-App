package Bank.account;

import java.util.HashMap;

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

    // Add account to user account Map
    public void addAccount(int accountID, double accountBalance){
        userAccMap.put(accountID, accountBalance);
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



}
