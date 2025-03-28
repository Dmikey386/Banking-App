package Bank.transactions.singleTransactions;

import Bank.account.*;
import Bank.transactions.transactionProcessing.TransactionRequest;
import Bank.user.User;
import Bank.user.UserLogger;

import java.io.IOException;

public class Transaction{
    protected String[] accountIDs;
    protected double amount;
    protected AccountLogger accountLogger = AccountLogger.getInstance();
    protected UserLogger userLogger = UserLogger.getInstance();


    public Transaction(TransactionRequest request) throws IOException {
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





