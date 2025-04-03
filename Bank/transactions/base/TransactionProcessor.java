package bank.transactions.base;

import java.io.IOException;
import bank.transactions.loggers.TransactionLogger;

public class TransactionProcessor {
    private TransactionLogger transactionLogger = TransactionLogger.getInstance();
    private TransactionVerifier verifier = new TransactionVerifier();


    public synchronized void process(Transaction request) throws IOException {
        verifier.verifyTransaction(request);
        if (request.getApproval()){
            request.process();
        }
        logTransaction(request);
    }

    public void logTransaction(Transaction transaction) throws IOException {
        transactionLogger.logTransaction(transaction);
    }
}
