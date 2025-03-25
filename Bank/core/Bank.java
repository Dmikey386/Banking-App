package Bank.core;
import Bank.IDTools.AccountIDGenerator;
import Bank.IDTools.UserIDGenerator;
import Bank.JsonStorage.JsonLogger;
import Bank.account.*;
import Bank.user.User;
import Bank.transactions.TransactionLogger;
import Bank.transactions.TransactionProcessor;

import java.io.IOException;
import java.util.HashMap;

import Bank.IDTools.UniqueIDGenerator;
import Bank.transactions.TransactionRequest;
import Bank.user.UserLogger;


public class Bank {
    private TransactionProcessor transactionProcessor = new TransactionProcessor(this);
    private UserLogger userLogger = new UserLogger();
    private AccountLogger accountStorage = new AccountLogger();
    private final UniqueIDGenerator accountIDGenerator = new AccountIDGenerator();
    private final UniqueIDGenerator userIDGenerator = new UserIDGenerator();


    // Bank Getters


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

    public void createUser () throws IOException {
        String userID = userIDGenerator.generateID();
        User user = new User(userID);
        userLogger.logUser(userID,user);

    }



    public void processTransaction(TransactionRequest request){
        transactionProcessor.processTransaction(request);
    }


}
