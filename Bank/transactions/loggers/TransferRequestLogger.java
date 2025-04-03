package bank.transactions.loggers;

import bank.persistentstorage.JsonLogger;
import bank.transactions.wiretrasfer.WireTransfer;

import java.io.IOException;

public class TransferRequestLogger extends JsonLogger<WireTransfer> {
    private static TransferRequestLogger single_instance = null;

    // wrapper for singleton
    public static TransferRequestLogger getInstance() {
        // ensure only one instance
        if(single_instance == null){
            single_instance = new TransferRequestLogger();
        }
        return single_instance;
    }
    // constructor
    private TransferRequestLogger() {
        super("Storage/wiretransferrequests.json");
    }

    public void logRequest(WireTransfer request) throws IOException {
        logObject(request.getTransferID(),request);
    }
}
