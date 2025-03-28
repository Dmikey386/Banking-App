package Bank.transactions.singleTransactions;

import Bank.account.BankAccount;
import Bank.transactions.transactionProcessing.TransactionRequest;

import java.io.IOException;

public class DirectDeposit extends Transaction {

    // constructor
    public DirectDeposit(TransactionRequest request) throws IOException {
        super(request);
    }

    @Override
    public void process() throws IOException {
        BankAccount[] accounts = getAccounts(accountIDs);
        accounts[0].setBalance(accounts[0].getBalance() + amount);
        updateLogs(accounts);
    }



}


