package Bank.core;
import Bank.IDTools.AccountIDGenerator;
import Bank.IDTools.UserIDGenerator;
import Bank.account.*;
import Bank.user.User;
import Bank.transactions.TransactionLogger;
import Bank.transactions.TransactionProcessor;
import java.io.IOException;
import Bank.IDTools.UniqueIDGenerator;
import Bank.transactions.TransactionRequest;
import Bank.user.UserLogger;


public class Bank {
    private TransactionProcessor transactionProcessor = new TransactionProcessor(this);
    private UserLogger userLog = new UserLogger();
    private AccountLogger  accountLog = new AccountLogger();
    private TransactionLogger transactionLogger = new TransactionLogger();
    private final UniqueIDGenerator accountIDGenerator = new AccountIDGenerator();
    private final UniqueIDGenerator userIDGenerator = new UserIDGenerator();

    // get User
    public User getUser(String userID) throws IOException {
        return userLog.getUser(userID);
    }
    public BankAccount getAccount(String accountID) throws IOException {
        return accountLog.getAccount(accountID);
    }
    public UserLogger getUserLog(){
        return userLog;
    }
    public AccountLogger getaccountLog(){
        return accountLog;
    }
    // Open new account
    public String openAccount(String accountType, String userID) throws IOException {
        String accountID = accountIDGenerator.generateID();
        User user = getUser(userID);

        // create new account
        switch (accountType) {
            case "Checking":
                CheckingAccount newChecking = new CheckingAccount(accountID);
                accountLog.logAccount(accountID, newChecking);
                user.addAccount(accountID,newChecking.getBalance());
                break;
            case "Savings":
                SavingsAccount newSavings = new SavingsAccount(accountID);
                accountLog.logAccount(accountID, newSavings);
                user.addAccount(accountID,newSavings.getBalance());
                break;
            default: // would not occur if there was a button to pick
                System.out.println("Invalid account type");
                break;
        }
        userLog.logUser(userID,user);

        return accountID;
    }

    public void createUser() throws IOException {
        String userID = userIDGenerator.generateID();
        User user = new User(userID);
        userLog.logUser(userID,user);

    }

    public void createTransaction(String userID, String[] accounts, double amount, int transactionType) throws IOException {
        User user = getUser(userID);
        TransactionRequest request = user.createTransactionRequest(accounts, amount, transactionType);
        processTransaction(request);
    }

    public void logTransaction(TransactionRequest request) throws IOException {
        String transactionID = request.getTransactionID();
        transactionLogger.logTransaction(transactionID,request);

    }

    public void processTransaction(TransactionRequest request) throws IOException {
        transactionProcessor.processTransaction(request);
        logTransaction(request);
    }


}
