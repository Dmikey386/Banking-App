package Bank.singleTransactions;

import Bank.account.BankAccount;
import Bank.core.Bank;

import java.io.IOException;

public class WireTransfer extends Transaction {
    // constructor
    public WireTransfer(String[] accountIDs, double amount) throws IOException {
        super(accountIDs, amount);
    }
    @Override
    public void process() throws IOException {
        BankAccount[] accounts = getAccounts(accountIDs);
        accounts[0].setBalance(accounts[0].getBalance() - amount); //withdraw
        accounts[1].setBalance(accounts[1].getBalance() + amount); //deposit
        updateLogs(accounts);
    }
   }