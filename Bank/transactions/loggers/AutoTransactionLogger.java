package bank.transactions.loggers;


import bank.transactions.automatic.AutoTransaction;
import bank.persistentstorage.JsonLogger;
import java.io.IOException;

public class AutoTransactionLogger extends JsonLogger<AutoTransaction> {
    private static AutoTransactionLogger single_instance = null;

    // wrapper for singleton
    public static AutoTransactionLogger getInstance() {
        // ensure only one instance
        if(single_instance == null){
            single_instance = new AutoTransactionLogger();
        }
        return single_instance;
    }

    // Constructor
    public AutoTransactionLogger() {
        super("Storage/autotransactions.json");
    }

    public void logAutoTransaction(AutoTransaction autoTransaction) throws IOException {
        logObject(autoTransaction.getAutoTransactionID(),autoTransaction);
    }

}
