package Bank.transactions;

import Bank.account.BankAccount;
import Bank.core.Bank;

import java.io.IOException;

public class Deposit extends Transaction {

    // constructor
    public Deposit(Bank bank, String[] accountIDs, double amount) throws IOException {
        super(bank, accountIDs, amount);
    }

    @Override
    public void process() throws IOException {
        BankAccount[] accounts = getAccounts(accountIDs);
        accounts[0].setBalance(accounts[0].getBalance() + amount);
        updateLogs(accounts);
    }



}


