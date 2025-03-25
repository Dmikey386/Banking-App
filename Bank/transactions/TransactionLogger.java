package Bank.transactions;

import Bank.JsonStorage.JsonLogger;
import java.io.IOException;


public class TransactionLogger extends JsonLogger<TransactionRequest> {


    // constructor
    public TransactionLogger() {
        super("Storage/transactions.json");
    }

    public void logTransaction(String transactionID, TransactionRequest transactionRequest) throws IOException {
        logObject(transactionID,transactionRequest);
    }

}
