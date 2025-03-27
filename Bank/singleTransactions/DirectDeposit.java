package Bank.singleTransactions;

import Bank.account.BankAccount;
import java.io.IOException;

public class DirectDeposit extends Transaction {

    // constructor
    public DirectDeposit(String[] accountIDs, double amount) throws IOException {
        super(accountIDs, amount);
    }

    @Override
    public void process() throws IOException {
        BankAccount[] accounts = getAccounts(accountIDs);
        accounts[0].setBalance(accounts[0].getBalance() + amount);
        updateLogs(accounts);
    }



}


