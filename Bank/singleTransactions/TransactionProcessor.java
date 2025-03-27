package Bank.singleTransactions;

import Bank.core.Bank;
import java.io.IOException;


public class TransactionProcessor {
    private Bank bank;

    // constructor
    public TransactionProcessor(Bank bank) {
        this.bank = bank;
    }


    // Verify transaction
    public void verifyTransaction(TransactionRequest transactionRequest) throws IOException {
        TransactionVerifier verifier = new TransactionVerifier(transactionRequest);
        verifier.verifyTransaction();
    }

    // Process the transaction
    public void processTransaction(TransactionRequest transactionRequest) throws IOException {

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
        String[] accountIDs = transactionRequest.getAccountIDs();
        double amount = transactionRequest.getAmount();

        switch (type) {
            case 0:
                transaction = new DirectDeposit(accountIDs, amount);
                break;
            case 1:
                transaction = new Withdraw(accountIDs, amount);
                break;
            case 2:
                transaction = new WireTransfer(accountIDs, amount);
                break;
            default:
                System.out.println("Invalid transaction type");

        }
        return transaction;

    }



}
