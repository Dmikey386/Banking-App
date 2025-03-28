package bank.transactions.base;

import bank.account.BankAccount;
import bank.transactions.wire.WireTransferRequest;

import java.io.IOException;

public class Withdraw extends Transaction {
    // constructor
    public Withdraw(WireTransferRequest request) throws IOException {
        super(request);
    }

    @Override
    public void process() throws IOException {
        BankAccount[] accounts = getAccounts(accountIDs);
        accounts[0].setBalance(accounts[0].getBalance() - amount);
        updateLogs(accounts);
    }
}
