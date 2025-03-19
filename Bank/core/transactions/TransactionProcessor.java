package Bank.core.transactions;

import Bank.account.BankAccount;
import Bank.account.TransactionRequest;
import Bank.core.Bank;

import java.util.ArrayList;
import java.util.Random;


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
    public void processTransaction(TransactionRequest transactionRequest) {
        String transactionID = transactionRequest.getTransactionID(); // get the transaction ID

        verifyTransaction(transactionRequest);
        logTransaction(transactionID, transactionRequest);

        if (!transactionRequest.getStatus()) {
            System.out.println(transactionRequest.getFailureStatement());
        } else {
            Transaction transaction = createTransaction(transactionRequest);
            transaction.process();
        }


    }

    // create the transaction
    public Transaction createTransaction(TransactionRequest transactionRequest) {

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
    public BankAccount[] getAccounts(TransactionRequest transactionRequest) {
        int[] accountIDs = transactionRequest.getAccountIDs();
        BankAccount[] accounts = new BankAccount[accountIDs.length];

        for (int i = 0; i < accountIDs.length; i++) {

            accounts[i] = bank.getAccount(accountIDs[i]);
        }
        return accounts;
    }

    // Log transaction data to bank and involved accounts
    public void logTransaction(String transactionID, TransactionRequest transactionRequest) {
        BankAccount[] accounts = getAccounts(transactionRequest);

        boolean status = transactionRequest.getStatus();
        double amount = transactionRequest.getAmount();
        int type = transactionRequest.getTransactionType();

        ArrayList<Object> depositerMetadata = new ArrayList<>();
        ArrayList<Object> withdrawalMetadata = new ArrayList<>();

        depositerMetadata.add(type);
        depositerMetadata.add(status);
        withdrawalMetadata.add(type);
        depositerMetadata.add(status);


        switch (type) {
            case 0:
                depositerMetadata.add(amount);
                accounts[0].logTransaction(transactionID, depositerMetadata);
                break;
            case 1:
                withdrawalMetadata.add(-amount);
                accounts[0].logTransaction(transactionID, withdrawalMetadata);
                break;
            case 2:
                withdrawalMetadata.add(-amount);
                accounts[0].logTransaction(transactionID, withdrawalMetadata);
                depositerMetadata.add(2, amount); // change metadata for deposit account
                accounts[1].logTransaction(transactionID, depositerMetadata);

                bank.logTransaction(transactionID, transactionRequest);
        }
    }
}
