package Bank.core;
import Bank.IDTools.AccountIDGenerator;
import Bank.account.*;
import Bank.core.transactions.Transaction;
import Bank.core.transactions.TransactionProcessor;

import java.util.HashMap;
import java.util.Random;
import Bank.IDTools.UniqueIDGenerator;


public class Bank {
    private double monetaryBase;
    private HashMap<String, User> users = new HashMap<>();
    private HashMap<String, BankAccount> accounts = new HashMap<>();
    private TransactionProcessor transactionProcessor = new TransactionProcessor(this);
    private TransactionLogger transactionStorage  = new TransactionLogger();
    private final UniqueIDGenerator accountIDGenerator = new AccountIDGenerator();

    // bank is modified, because accounts are only stored in user data
    public Bank() {
    }


    // Bank Getters
    public BankAccount getAccount (int accountID){
        return accounts.get(accountID);
    }
    public User getUser (int userID){
        return users.get(userID);
    }
    public HashMap<String, BankAccount> getAccountsHashMap(){
        return accounts;
    }
    public HashMap<String, User> getUsersHashMap(){
        return users;
    }

    // Open new account
    public String openAccount(String accountType, User user) {
        String accountID = accountIDGenerator.generateID();

        // create new account
        switch (accountType) {
            case "Checking":
                CheckingAccount newChecking = new CheckingAccount(accountID);
                accounts.put(accountID, newChecking);
                user.addAccount(accountID,newChecking.getBalance());
                break;
            case "Savings":
                SavingsAccount newSavings = new SavingsAccount(accountID);
                accounts.put(accountID, newSavings);
                user.addAccount(accountID,newSavings.getBalance());
                break;
            default: // would not occur if there was a button to pick
                System.out.println("Invalid account type");
                break;
        }

        return accountID;
    }

    public void createUser (){
        User user = new User(userID);
        users.put(userID, user);
    }

    public void logTransaction(String TransactionID, TransactionRequest transaction) {
        transactionStorage.logTransaction(TransactionID, transaction);
    }

    public void processTransaction(TransactionRequest request){
        transactionProcessor.processTransaction(request);
    }


}
