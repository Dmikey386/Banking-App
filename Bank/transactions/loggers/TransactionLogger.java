package bank.transactions.loggers;

import bank.persistentstorage.JsonLogger;
import bank.transactions.base.Transaction;

import java.io.IOException;


public class TransactionLogger extends JsonLogger<Transaction> {
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

    public void logTransaction(Transaction txn) throws IOException {
        logObject(txn.getTransactionID(),txn);
    }


}
