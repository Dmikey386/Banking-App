package bank.transactions.base;

import bank.persistentstorage.TransactionLogger;
import bank.transactions.wire.WireTransferRequest;

import java.io.IOException;


public class TransactionProcessor {
    private TransactionLogger transactionLogger = TransactionLogger.getInstance();
    private TransactionFactory transactionFactory = new TransactionFactory();


    // Verify transaction
    public void verifyTransaction(WireTransferRequest transactionRequest) throws IOException {
        TransactionVerifier verifier = new TransactionVerifier(transactionRequest);
        verifier.verifyTransaction();
    }

    // Process the transaction
    public void processTransaction(WireTransferRequest transactionRequest) throws IOException {

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
