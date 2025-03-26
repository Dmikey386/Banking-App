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
        BankAccount depositAccount = accounts[0];
        depositAccount.setBalance(depositAccount.getBalance() + amount);
        String depositAccountID = accountIDs[0];
        logger.logAccount(depositAccountID,depositAccount);
    }



}


