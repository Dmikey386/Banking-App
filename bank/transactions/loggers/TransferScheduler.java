package bank.transactions.loggers;


import bank.persistentstorage.JsonLogger;
import bank.transactions.auto.AutoWireTransfer;

import java.io.IOException;
import java.util.*;


public class TransferScheduler extends JsonLogger<ArrayList<String>> {
    private static volatile TransferScheduler single_instance;

    // wrapper for singleton
    public static TransferScheduler getInstance() {
        // ensure only one instance
        if(single_instance == null){
            synchronized (TransferScheduler.class){
                if(single_instance == null){
                    single_instance = new TransferScheduler();
                }
            }
        }
        return single_instance;
    }
    public TransferScheduler() {
        super("Storage/transferschedule.json");
    }

    // schedule a recurring transfer to a given date
    public void logObjectToDate(AutoWireTransfer autoWireTransfer) throws IOException {
        String date = autoWireTransfer.getNextDate();
        String transferID = autoWireTransfer.getWireID();
        ArrayList<String> txnsOnDate;
        HashMap<String, ArrayList<String>> log = readLog();
        if (log.containsKey(date)) {
            txnsOnDate = log.get(date);
            txnsOnDate.add(transferID);
        }
        else {
            txnsOnDate = new ArrayList<>();
            txnsOnDate.add(transferID);
        }
        log.put(date, txnsOnDate);
        writeJson(log);
    }

    // delete date after scheduled payments have completed
    public void deleteDate(String date) throws IOException {
        HashMap<String, ArrayList<String>> log = readLog();
        log.remove(date);
        writeJson(log);
    }



}
