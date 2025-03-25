package Bank.transactions;

import Bank.account.BankAccount;

import java.util.Map;
import java.util.HashMap;

public class TransactionLogger<T> {
    // Attributes
    private Map<String, T> transactionLog = new HashMap<>();

    public void logTransaction(String TransactionID, T transaction) {
        transactionLog.put(TransactionID,transaction);
    }
}
