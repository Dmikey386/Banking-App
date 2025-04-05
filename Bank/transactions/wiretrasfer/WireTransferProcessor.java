package bank.transactions.wiretrasfer;

import bank.account.AccountLogger;
import bank.transactions.base.Transaction;
import bank.transactions.base.TransactionException;
import bank.transactions.base.TransactionFactory;
import bank.transactions.loggers.TransactionLogger;
import bank.transactions.loggers.TransferRequestLogger;
import bank.user.UserLogger;

import java.io.IOException;

public class WireTransferProcessor {
    private WireTransferVerifier wireVerifier = new WireTransferVerifier();
    private TransferRequestLogger wireLogger = TransferRequestLogger.getInstance();
    private TransactionLogger transactionLogger = TransactionLogger.getInstance();


    public void processRequest(WireTransfer request) throws IOException {
        Transaction withdraw = TransactionFactory.createTransaction("Withdraw", request.getFromAccountID(), request.getAmount());
        Transaction deposit = TransactionFactory.createTransaction("Deposit",request.getToAccountID(), request.getAmount());
        wireVerifier.verifyWireTransfer(request,withdraw,deposit);
        request.setWithdrawID(withdraw.getTransactionID());
        if (request.getApproval() && withdraw.getApproval() && deposit.getApproval()) {
            withdraw.process();
            deposit.process();
            request.setDepositID(deposit.getTransactionID());
            transactionLogger.logTransaction(deposit);
        }
        transactionLogger.logTransaction(withdraw);
        logWireTransfer(request);
    }

    public void logWireTransfer(WireTransfer request) throws IOException {
        wireLogger.logRequest(request);
    }


}
