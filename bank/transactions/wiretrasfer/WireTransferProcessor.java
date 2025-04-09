package bank.transactions.wiretrasfer;

import bank.locking.AccountLocker;
import bank.transactions.base.Transaction;
import bank.transactions.base.TransactionFactory;
import bank.transactions.loggers.TransactionLogger;
import bank.transactions.loggers.TransferLogger;

import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

public class WireTransferProcessor {
    private WireTransferVerifier wireVerifier = new WireTransferVerifier();
    private TransferLogger wireLogger = TransferLogger.getInstance();
    private TransactionLogger transactionLogger = TransactionLogger.getInstance();


    public void processRequest(WireTransfer request) throws IOException {
        Transaction withdraw = TransactionFactory.createTransaction("Withdraw", request.getFromAccountID(), request.getAmount());
        Transaction deposit = TransactionFactory.createTransaction("Deposit",request.getToAccountID(), request.getAmount());

        String acct1 = request.getFromAccountID();
        String acct2 = request.getToAccountID();

        String first = acct1.compareTo(acct2) < 0 ? acct1 : acct2;
        String second = acct1.compareTo(acct2) < 0 ? acct2 : acct1;

        ReentrantLock firstLock = AccountLocker.getInstance().getLock(first);
        ReentrantLock secondLock = AccountLocker.getInstance().getLock(second);
        firstLock.lock();
        secondLock.lock();
        try{
            wireVerifier.verifyWireTransfer(request,withdraw,deposit);
            request.setWithdrawID(withdraw.getTransactionID());
            if (request.getApproval() && withdraw.getApproval() && deposit.getApproval()) {
                withdraw.processAsTransfer();
                deposit.processAsTransfer();
                request.setDepositID(deposit.getTransactionID());
                transactionLogger.logTransaction(deposit);
            }
        } finally {
            secondLock.unlock();
            firstLock.unlock();
        }
        transactionLogger.logTransaction(withdraw);
        logWireTransfer(request);
    }

    public void logWireTransfer(WireTransfer request) throws IOException {
        wireLogger.logRequest(request);
    }


}
