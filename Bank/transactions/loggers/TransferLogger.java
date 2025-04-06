package bank.transactions.loggers;

import bank.persistentstorage.JsonLogger;
import bank.transactions.wiretrasfer.WireTransfer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.IOException;


public class TransferLogger extends JsonLogger<WireTransfer> {
    private static TransferLogger single_instance = null;

    // wrapper for singleton
    public static TransferLogger getInstance() {
        // ensure only one instance
        if(single_instance == null){
            single_instance = new TransferLogger();
        }
        return single_instance;
    }
    // constructor
    private TransferLogger() {
        super("Storage/transfers.json");
    }

    public void logRequest(WireTransfer request) throws IOException {
        logObject(request.getWireID(),request);
    }
}
