package Bank.core;
import Bank.IDTools.AccountIDGenerator;
import Bank.IDTools.UserIDGenerator;
import Bank.account.*;
import Bank.user.User;
import Bank.transactions.TransactionLogger;
import Bank.transactions.TransactionProcessor;

import java.util.HashMap;

import Bank.IDTools.UniqueIDGenerator;
import Bank.transactions.TransactionRequest;


public class Bank {
    private double monetaryBase;
    private HashMap<String, User> users = new HashMap<>();
    private TransactionProcessor transactionProcessor = new TransactionProcessor(this);
    private TransactionLogger transactionStorage  = new TransactionLogger();
    private AccountLogger accountStorage = new AccountLogger();
    private final UniqueIDGenerator accountIDGenerator = new AccountIDGenerator();
    private final UniqueIDGenerator userIDGenerator = new UserIDGenerator();

    // bank is modified, because accounts are only stored in user data
    public Bank() {
    }


    // Bank Getters
    public BankAccount getAccount (String accountID){
        return accountStorage.getAccount(accountID);
    }
    public User getUser (int userID){
        return users.get(userID);
    }
    public AccountLogger getAccountLog(){
        return accountStorage;
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
                accountStorage.logAccount(accountID, newChecking);
                user.addAccount(accountID,newChecking.getBalance());
                break;
            case "Savings":
                SavingsAccount newSavings = new SavingsAccount(accountID);
                accountStorage.logAccount(accountID, newSavings);
                user.addAccount(accountID,newSavings.getBalance());
                break;
            default: // would not occur if there was a button to pick
                System.out.println("Invalid account type");
                break;
        }

        return accountID;
    }

    public void createUser (){
        String userID = accountIDGenerator.generateID();
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
