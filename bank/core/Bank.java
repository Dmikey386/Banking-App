package bank.core;

import bank.idtools.UserIDGenerator;
import java.io.IOException;
import java.util.HashMap;
import bank.idtools.UniqueIDGenerator;
import bank.transactions.auto.AutoTransactionProcessor;
import bank.transactions.auto.AutoWireTransfer;
import bank.transactions.loggers.TransferScheduler;
import bank.transactions.base.Transaction;
import bank.transactions.base.TransactionFactory;
import bank.transactions.base.TransactionProcessor;
import bank.transactions.wiretrasfer.WireTransfer;
import bank.transactions.wiretrasfer.WireTransferFactory;
import bank.transactions.wiretrasfer.WireTransferProcessor;
import bank.user.*;
import bank.account.*;
import bank.transactions.loggers.*;


public class Bank {
    private static volatile Bank instance;
    private UserLogger userLog = UserLogger.getInstance();
    private AccountLogger accountLog = AccountLogger.getInstance();
    private TransferScheduler transferSchedule = TransferScheduler.getInstance();
    private ScheduleRequestLog scheduleRequestLog = ScheduleRequestLog.getInstance();
    private final TransactionProcessor transactionProcessor = new TransactionProcessor();
    private final TransactionFactory transactionFactory = new TransactionFactory();
    private final WireTransferProcessor wireTransferProcessor = new WireTransferProcessor();
    private final WireTransferFactory wireTransferFactory = new WireTransferFactory();
    private final AccountFactory accountFactory = new AccountFactory();
    private final UniqueIDGenerator userIDGenerator = new UserIDGenerator();
    AutoTransactionProcessor autoTransactionProcessor = new AutoTransactionProcessor();

    private Bank(){}
    public static Bank getInstance(){
        if(instance == null){
            synchronized(Bank.class){
                if(instance == null){
                    instance = new Bank();
                }
            }
        }
        return instance;
    }

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
    public void processTransferRequest(String userID, String fromAccountID, String toAccountID, double amount) throws IOException {
        WireTransfer request = wireTransferFactory.createWire(userID, fromAccountID, toAccountID, amount);
        wireTransferProcessor.processRequest(request);
    }
    public void scheduleRecurringTransfer(String userID, String fromAccountID, String toAccountID, double amount, String rate, String StartDate) throws IOException {
        AutoWireTransfer request = wireTransferFactory.createWire(userID,fromAccountID,toAccountID,amount,rate,StartDate);
        scheduleRequestLog.logRequest(request);
        transferSchedule.logObjectToDate(request);
    }
    public void processRecurringPayments() throws IOException {
        autoTransactionProcessor.processAutoTransfers();
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
