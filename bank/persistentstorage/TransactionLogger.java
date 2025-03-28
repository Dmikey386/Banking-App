package bank.persistentstorage;

import bank.transactions.wire.WireTransferRequest;

import java.io.IOException;


public class TransactionLogger extends JsonLogger<WireTransferRequest> {
    private static TransactionLogger single_instance = null;

    // wrapper for singleton
    public static TransactionLogger getInstance() {
        // ensure only one instance
        if(single_instance == null){
            single_instance = new TransactionLogger();
        }
        return single_instance;
    }
    // constructor
    private TransactionLogger() {
        super("Storage/transactions.json");
    }

    public void logTransaction(WireTransferRequest transactionRequest) throws IOException {
        logObject(transactionRequest.getTransactionID(),transactionRequest);
    }


}
