package Bank.singleTransactions;

import Bank.jsonStorage.JsonLogger;

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

    public void logTransaction(String transactionID, TransactionRequest transactionRequest) throws IOException {
        logObject(transactionID,transactionRequest);
    }


}
