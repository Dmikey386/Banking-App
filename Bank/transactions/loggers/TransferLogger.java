package bank.transactions.loggers;

import bank.persistentstorage.JsonLogger;
import bank.transactions.wiretrasfer.WireTransfer;

import java.io.IOException;


public class TransferLogger extends JsonLogger<WireTransfer> {
    private static volatile TransferLogger single_instance;

    // wrapper for singleton
    public static TransferLogger getInstance() {
        // ensure only one instance
        if(single_instance == null){
            synchronized (TransferLogger.class){
                if(single_instance == null){
                    single_instance = new TransferLogger();
                }
            }
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
