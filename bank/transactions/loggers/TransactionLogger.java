package bank.transactions.loggers;

import bank.persistentstorage.JsonLogger;
import bank.transactions.base.Transaction;
import java.io.IOException;


public class TransactionLogger extends JsonLogger<Transaction> {
    private static volatile TransactionLogger single_instance;

    // wrapper for singleton
    public static TransactionLogger getInstance() {
        // ensure only one instance
        if(single_instance == null){
            synchronized (TransactionLogger.class){
                if(single_instance == null){
                    single_instance = new TransactionLogger();
                }
            }
        }
        return single_instance;
    }
    // constructor
    private TransactionLogger() {
        super("Storage/transactions.json");
    }

    public void logTransaction(Transaction txn) throws IOException {
        logObject(txn.getTransactionID(),txn);
    }


}
