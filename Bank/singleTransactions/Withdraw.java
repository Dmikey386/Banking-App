package Bank.singleTransactions;

import Bank.account.BankAccount;
import Bank.core.Bank;

import java.io.IOException;

public class Withdraw extends Transaction {
    // constructor
    public Withdraw(String[] accountIDs, double amount) throws IOException {
        super(accountIDs, amount);
    }

    @Override
    public void process() throws IOException {
        BankAccount[] accounts = getAccounts(accountIDs);
        accounts[0].setBalance(accounts[0].getBalance() - amount);
        updateLogs(accounts);
    }
}
