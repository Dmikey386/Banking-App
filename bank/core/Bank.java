package bank.core;

import bank.idtools.UserIDGenerator;
import java.io.IOException;
import java.util.HashMap;
import bank.idtools.UniqueIDGenerator;
import bank.transactions.base.Transaction;
import bank.transactions.base.TransactionFactory;
import bank.transactions.base.TransactionProcessor;
import bank.user.*;
import bank.account.*;
import bank.transactions.loggers.*;


public class Bank {
    private UserLogger userLog = UserLogger.getInstance();
    private AccountLogger accountLog = AccountLogger.getInstance();
    private TransactionLogger transactionLogger = TransactionLogger.getInstance();
    private final TransactionProcessor transactionProcessor = new TransactionProcessor();
    private final TransactionFactory transactionFactory = new TransactionFactory();
    private final AccountFactory accountFactory = new AccountFactory();
    private final UniqueIDGenerator userIDGenerator = new UserIDGenerator();

    // Getters
    public User getUser(String userID) throws IOException {
        return userLog.getUser(userID);
    }
    public BankAccount getAccount(String accountID) throws IOException {
        return accountLog.getAccount(accountID);
    }

    // Open new account
    public void openAccount(String accountType, String userID) throws IOException {
        BankAccount account = accountFactory.createAccount(accountType, userID);
        User user = getUser(userID);
        accountLog.logAccount(account);
        user.addAccount(account);
        userLog.logUser(user);
    }
    // create a new user
    public void createUser() throws IOException {
        String userID = userIDGenerator.generateID();
        User user = new User(userID);
        userLog.logUser(user);
    }

    // process a base transaction
    public void processTransaction(double amount, String accountID,String type) throws IOException {
            Transaction transaction = transactionFactory.createTransaction(type, accountID, amount);
            transactionProcessor.process(transaction);
    }
    // reset account daily/monthly limits
    public void resetLimits() throws IOException {
        HashMap<String, BankAccount> entry =  accountLog.readLog();
        for (Object rawAccountData : entry.values()) {
            HashMap<String,Object> attrMap = (HashMap<String,Object>)rawAccountData;
            BankAccount account = accountLog.getAccount(attrMap.get("accountID").toString());
            account.checkAndResetLimits();
            accountLog.logAccount(account);
        }

    }
}
