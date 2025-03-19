package Bank.core;
import Bank.account.*;
import Bank.core.transactions.Transaction;
import Bank.core.transactions.TransactionProcessor;

import java.util.HashMap;
import java.util.Random;


public class Bank {
    private double monetaryBase;
    private HashMap<Integer, User> users = new HashMap<>();
    private HashMap<Integer, BankAccount> accounts = new HashMap<>();
    private TransactionProcessor transactionProcessor = new TransactionProcessor(this);
    private TransactionLogger transactionStorage  = new TransactionLogger();

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
    public HashMap<Integer, BankAccount> getAccountsHashMap(){
        return accounts;
    }
    public HashMap<Integer, User> getUsersHashMap(){
        return users;
    }

    // Open new account
    public int openAccount(String accountType, User user) {
        Random rand = new Random();

        // Check for valid account number in database
        int accountNumber = rand.nextInt(1000);

        // create new account
        switch (accountType) {
            case "Checking":
                CheckingAccount newChecking = new CheckingAccount(accountNumber);
                accounts.put(accountNumber, newChecking);
                user.addAccount(accountNumber,newChecking.getBalance());
                break;
            case "Savings":
                SavingsAccount newSavings = new SavingsAccount(accountNumber);
                accounts.put(accountNumber, newSavings);
                user.addAccount(accountNumber,newSavings.getBalance());
                break;
            default: // would not occur if there was a button to pick
                System.out.println("Invalid account type");
                break;
        }

        return accountNumber;
    }

    public void createUser (int userID){
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
