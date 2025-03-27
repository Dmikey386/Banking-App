package Bank.singleTransactions;

import Bank.account.*;
import Bank.core.Bank;
import Bank.user.User;
import Bank.user.UserLogger;

import java.io.IOException;

public class Transaction{
    protected Bank bank;
    protected String[] accountIDs;
    protected double amount;
    protected AccountLogger accountLogger = bank.getAccountLog();
    protected UserLogger userLogger = bank.getUserLog();


    public Transaction(Bank bank, String[] accountIDs, double amount) throws IOException {
        this.bank = bank;
        this.accountIDs = accountIDs;
        this.amount = amount;

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
            accountLogger.logAccount(accountID,accounts[i]);

            // updates user
            String userID = accounts[i].getUserID();
            System.out.println(userID);
            User user = userLogger.getUser(userID);
            user.addAccount(accountID,accounts[i].getBalance());
            userLogger.logUser(userID,user);
        }

    }

    public void process() throws IOException {
    }

}





