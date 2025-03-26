package Bank.transactions;

import Bank.account.*;
import Bank.core.Bank;
import java.io.IOException;

public class Transaction{
    protected Bank bank;
    protected String[] accountIDs;
    protected double amount;
    protected AccountLogger logger;


    public Transaction(Bank bank, String[] accountIDs, double amount) throws IOException {
        this.bank = bank;
        this.accountIDs = accountIDs;
        this.amount = amount;
        this.logger = bank.getaccountLog();
    }

    public BankAccount[] getAccounts(String[] accountIDs) throws IOException {
        BankAccount[] accounts = new BankAccount[accountIDs.length];
        for (int i = 0; i < accountIDs.length; i++){
            BankAccount account = logger.getAccount(accountIDs[i]);
            System.out.println(account.getBalance());
            accounts[i] = account;
        }
        return accounts;
    }


    public void process() throws IOException {
    }

}





