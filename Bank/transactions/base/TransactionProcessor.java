package bank.transactions.base;

import java.io.IOException;
import bank.locking.AccountLocker;
import bank.transactions.loggers.TransactionLogger;
import java.util.concurrent.locks.ReentrantLock;

public class TransactionProcessor {
    private TransactionLogger transactionLogger = TransactionLogger.getInstance();
    private TransactionVerifier verifier = new TransactionVerifier();


    public void process(Transaction request) throws IOException {
        ReentrantLock lock = AccountLocker.getInstance().getLock(request.getAccountID());
        lock.lock();
        try{
            verifier.verifyTransaction(request);
            if (request.getApproval()){
                Thread.sleep(1500);
                request.process(); // should print and process here
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }

        logTransaction(request);
    }

    public void logTransaction(Transaction txn) throws IOException {
        transactionLogger.logTransaction(txn);
    }
}
