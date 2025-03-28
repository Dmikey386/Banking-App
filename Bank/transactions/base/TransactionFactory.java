package bank.transactions.base;

import bank.transactions.wire.WireTransfer;
import bank.transactions.wire.WireTransferRequest;

import java.io.IOException;

public class TransactionFactory {
    public static Transaction createTransaction(WireTransferRequest transactionRequest) throws IOException {
        switch (transactionRequest.getTransactionType()) {
            case 0: return new DirectDeposit(transactionRequest);
            case 1: return new Withdraw(transactionRequest);
            case 2: return new WireTransfer(transactionRequest);
            default: throw new IllegalArgumentException("Invalid Transaction Type");
        }
    }
}
