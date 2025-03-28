package Bank.user;

import Bank.account.BankAccount;
import Bank.transactions.transactionProcessing.automatic.AutoTransactionRequest;
import Bank.transactions.transactionProcessing.single.TransactionRequest;

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
    public void addAccount(BankAccount account) {
        String accountID = account.getAccountID();
        double accountBalance = account.getBalance();
        userAccMap.put(accountID, accountBalance);
    }

    public boolean verifyAccount(String accountID){
        return userAccMap.containsKey(accountID);
    }

    // Request auto transaction
    public AutoTransactionRequest createAutoTransactionRequest(String[] accounts, String rate, double amount, int transactionType) {
        AutoTransactionRequest request = new AutoTransactionRequest.Builder()
                .userID(this.getUserID())
                .accountIDs(accounts)
                .amount(amount)
                .rate(rate)
                .transactionType(transactionType)
                .build();
        return request;
    }

    // Request Transaction
    public TransactionRequest createTransactionRequest(String[] accounts, double amount, int transactionType){
        TransactionRequest request = new TransactionRequest.Builder()
                .userID(this.getUserID())
                .accountIDs(accounts)
                .amount(amount)
                .transactionType(transactionType)
                .status(false)
                .auto(false)
                .build();

        return request;
    }



}
