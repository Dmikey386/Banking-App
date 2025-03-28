package Bank.transactions.singleTransactions;

import Bank.account.BankAccount;
import Bank.transactions.transactionProcessing.single.TransactionRequest;

import java.io.IOException;

public class WireTransfer extends Transaction {
    // constructor
    public WireTransfer(TransactionRequest request) throws IOException {
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