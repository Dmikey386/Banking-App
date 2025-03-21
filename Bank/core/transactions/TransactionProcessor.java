package Bank.core.transactions;

import Bank.account.BankAccount;
import Bank.account.TransactionRequest;
import Bank.core.Bank;

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


        switch (type) {
            case 0: // Deposit
                logToAccount(accounts[0], transactionID, status, type, amount);
                break;
            case 1: // Withdraw
                logToAccount(accounts[0], transactionID, status, type, -amount);
                break;
            case 2: // Wire Transfer
                logToAccount(accounts[0], transactionID, status, type, -amount);
                logToAccount(accounts[1], transactionID, status, type, amount);
                break;
        }


    }
    private void logToAccount(BankAccount account, String transactionID, boolean status, int type, double amount) {
        ArrayList<Object> metadata = new ArrayList<>();
        metadata.add(status);
        metadata.add(type);
        metadata.add(amount);
        account.logTransaction(transactionID, metadata);
    }

}
