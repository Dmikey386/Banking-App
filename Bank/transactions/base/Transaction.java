package bank.transactions.base;

import bank.account.*;
import bank.persistentstorage.AccountLogger;
import bank.transactions.wire.WireTransferRequest;
import bank.user.User;
import bank.persistentstorage.UserLogger;

import java.io.IOException;

public class Transaction{
    protected String[] accountIDs;
    protected double amount;
    protected AccountLogger accountLogger = AccountLogger.getInstance();
    protected UserLogger userLogger = UserLogger.getInstance();


    public Transaction(WireTransferRequest request) throws IOException {
        accountIDs = request.getAccountIDs();
        amount = request.getAmount();
    }

    public BankAccount[] getAccounts(String[] accountIDs) throws IOException {
        BankAccount[] accounts = new BankAccount[accountIDs.length];
        for (int i = 0; i < accountIDs.length; i++){
            BankAccount account = accountLogger.getAccount(accountIDs[i]);
            accounts[i] = account;
        }
        return accounts;
    }

    public void updateLogs(BankAccount[] accounts) throws IOException {
        for (int i = 0; i < accounts.length; i++){
            //update account
            String accountID = accounts[i].getAccountID();
            accountLogger.logAccount(accounts[i]);

            // updates user
            String userID = accounts[i].getUserID();
            User user = userLogger.getUser(userID);
            user.addAccount(accounts[i]);
            userLogger.logUser(user);
        }

    }

    public void process() throws IOException {
    }

}





