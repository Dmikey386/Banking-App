package Bank.automaticTransactions;

import Bank.jsonStorage.JsonLogger;
import java.io.IOException;

public class AutoTransactionLogger extends JsonLogger<AutoTransactionRequest> {
    // logger for automatic transaction

    // Constructor
    public AutoTransactionLogger() {
        super("Storage/autotransactions.json");
    }

    public void logAutoTransaction(String autoTrID, AutoTransactionRequest autoTrReq) throws IOException {
        logObject(autoTrID,autoTrReq);
    }

}
