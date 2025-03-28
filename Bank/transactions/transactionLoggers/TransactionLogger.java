package Bank.transactions.transactionLoggers;

import Bank.Storage.JsonLogger;
import Bank.transactions.transactionProcessing.single.TransactionRequest;

import java.io.IOException;


public class TransactionLogger extends JsonLogger<TransactionRequest> {
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

    public void logTransaction(TransactionRequest transactionRequest) throws IOException {
        logObject(transactionRequest.getTransactionID(),transactionRequest);
    }


}
