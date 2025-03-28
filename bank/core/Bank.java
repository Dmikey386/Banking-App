package bank.core;
import bank.idtools.UserIDGenerator;
import bank.account.*;
import bank.persistentstorage.AccountLogger;
import bank.user.User;
import bank.persistentstorage.TransactionLogger;
import bank.transactions.base.TransactionProcessor;
import java.io.IOException;
import bank.idtools.UniqueIDGenerator;
import bank.transactions.wire.WireTransferRequest;
import bank.persistentstorage.UserLogger;


public class Bank {
    private TransactionProcessor transactionProcessor = new TransactionProcessor();
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

    public void createTransaction(String userID, String[] accounts, double amount, int transactionType) throws IOException {
        User user = getUser(userID);
        WireTransferRequest request = user.createTransactionRequest(accounts, amount, transactionType);
        transactionProcessor.processTransaction(request);
    }
}
