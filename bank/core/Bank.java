package bank.core;

import bank.idtools.UserIDGenerator;
import java.io.IOException;
import bank.idtools.UniqueIDGenerator;
import bank.user.*;
import bank.account.*;
import bank.transactions.loggers.*;


public class Bank {
    private UserLogger userLog = UserLogger.getInstance();
    private AccountLogger accountLog = AccountLogger.getInstance();
    private TransactionLogger transactionLogger = TransactionLogger.getInstance();
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
    public void createUser() throws IOException {
        String userID = userIDGenerator.generateID();
        User user = new User(userID);
        userLog.logUser(user);

    }
}
