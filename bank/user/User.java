package bank.user;

import bank.account.BankAccount;
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


}
