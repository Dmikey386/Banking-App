package Bank.transactions.transactionLoggers;


import Bank.transactions.automaticTransactions.*;
import Bank.jsonStorage.JsonLogger;
import java.io.IOException;

public class AutoTransactionLogger extends JsonLogger<AutoTransaction> {
    // logger for automatic transaction

    // Constructor
    public AutoTransactionLogger() {
        super("Storage/autotransactions.json");
    }

    public void logAutoTransaction(AutoTransaction autoTransaction) throws IOException {
        logObject(autoTransaction.getAutoTransactionID(),autoTransaction);
    }

}
