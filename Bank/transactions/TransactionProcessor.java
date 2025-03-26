package Bank.transactions;

import Bank.account.BankAccount;
import Bank.core.Bank;

import java.io.IOException;
import java.util.ArrayList;


public class TransactionProcessor {
    private Bank bank;


    // constructor
    public TransactionProcessor(Bank bank) {
        this.bank = bank;
    }


    // Verify transaction
    public void verifyTransaction(TransactionRequest transactionRequest) {
        TransactionVerifier verifier = new TransactionVerifier(bank, transactionRequest);
        verifier.verifyTransaction();
    }

    // Process the transaction
    public void processTransaction(TransactionRequest transactionRequest) throws IOException {
        String transactionID = transactionRequest.getTransactionID(); // get the transaction ID

        verifyTransaction(transactionRequest);

        if (!transactionRequest.getStatus()) {
            System.out.println(transactionRequest.getFailureStatement());
        } else {
            Transaction transaction = createTransaction(transactionRequest);
            transaction.process();
        }


    }

    // create the transaction
    public Transaction createTransaction(TransactionRequest transactionRequest) throws IOException {

        int type = transactionRequest.getTransactionType();
        Transaction transaction = null;
        BankAccount[] accounts = getAccounts(transactionRequest);
        double amount = transactionRequest.getAmount();

        switch (type) {
            case 0:
                transaction = new Deposit(accounts, amount);
                break;
            case 1:
                transaction = new Withdraw(accounts, amount);
                break;
            case 2:
                transaction = new WireTransfer(accounts, amount);
                break;
            default:
                System.out.println("Invalid transaction type");

        }
        return transaction;

    }

    // Convert accountIDs to account objects
    public BankAccount[] getAccounts(TransactionRequest transactionRequest) throws IOException {
        String[] accountIDs = transactionRequest.getAccountIDs();
        BankAccount[] accounts = new BankAccount[accountIDs.length];

        for (int i = 0; i < accountIDs.length; i++) {

            accounts[i] = bank.getAccount(accountIDs[i]);
        }
        return accounts;
    }

}
