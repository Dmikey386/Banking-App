package Bank.transactions.transactionLoggers;

import Bank.Storage.JsonLogger;
import Bank.transactions.transactionProcessing.automatic.AutoTransactionRequest;

import java.io.IOException;

public class AutoTransactionRequestLogger extends JsonLogger<AutoTransactionRequest> {
    private static AutoTransactionRequestLogger single_instance = null;

    // wrapper for singleton
    public static AutoTransactionRequestLogger getInstance() {
        // ensure only one instance
        if(single_instance == null){
            single_instance = new AutoTransactionRequestLogger();
        }
        return single_instance;
    }
    // Constructor
    public AutoTransactionRequestLogger() {
        super("Storage/autotransactionrequests.json");
    }

    public void logAutoTransactionReqeust(AutoTransactionRequest request) throws IOException {
        logObject(request.getAutoTransactionID(), request);
    }
}
