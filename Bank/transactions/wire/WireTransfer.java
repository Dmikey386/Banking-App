package bank.transactions.wire;

import bank.account.BankAccount;
import bank.transactions.base.Transaction;

import java.io.IOException;

public class WireTransfer extends Transaction {
    // constructor
    public WireTransfer(WireTransferRequest request) throws IOException {
        super(request);
    }
    @Override
    public void process() throws IOException {
        BankAccount[] accounts = getAccounts(accountIDs);
        accounts[0].setBalance(accounts[0].getBalance() - amount); //withdraw
        accounts[1].setBalance(accounts[1].getBalance() + amount); //deposit
        updateLogs(accounts);
    }
   }