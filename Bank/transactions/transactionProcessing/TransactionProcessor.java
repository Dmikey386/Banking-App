package Bank.transactions.transactionProcessing;

import Bank.transactions.singleTransactions.Transaction;
import Bank.transactions.transactionLoggers.TransactionLogger;

import java.io.IOException;


public class TransactionProcessor {
    private TransactionLogger transactionLogger = TransactionLogger.getInstance();
    private TransactionFactory transactionFactory = new TransactionFactory();


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
            Transaction transaction = transactionFactory.createTransaction(transactionRequest);
            transaction.process();
        }
        transactionLogger.logTransaction(transactionRequest);

    }


}
