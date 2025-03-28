package Bank.transactions.transactionLoggers;

import Bank.transactions.transactionProcessing.AutoTransactionRequest;
import Bank.transactions.automaticTransactions.*;
import Bank.jsonStorage.JsonLogger;
import java.io.IOException;

public class AutoTransactionLogger extends JsonLogger<AutoTransactionRequest> {
    // logger for automatic transaction

    // Constructor
    public AutoTransactionLogger() {
        super("Storage/autotransactions.json");
    }

    public void logAutoTransaction(String autoTrID, AutoTransaction autoTransaction) throws IOException {
        logObject(autoTrID,autoTransaction);
    }

}
