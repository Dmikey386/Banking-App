package Bank.account;



import java.util.HashMap;

public class TransactionLogger<T> {
    // Attributes
    private HashMap<String, T> transactions = new HashMap<>();

    public void logTransaction(String TransactionID, T transaction) {
        transactions.put(TransactionID,transaction);
    }
}
