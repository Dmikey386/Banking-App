package Bank.automaticTransactions;


import Bank.jsonStorage.JsonLogger;

public class AutoTransactionLogger extends JsonLogger<AutoTransactionRequest> {
    // logger for automatic transaction

    // Constructor
    public AutoTransactionLogger() {
        super("Storage/transactions.json");
    }
}
