package bank.transactions.auto;

import bank.transactions.loggers.ScheduleRequestLog;
import bank.transactions.loggers.TransferScheduler;
import bank.transactions.wiretrasfer.WireTransfer;
import bank.transactions.wiretrasfer.WireTransferFactory;
import bank.transactions.wiretrasfer.WireTransferProcessor;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.ArrayList;


public class AutoTransactionProcessor {
    private TransferScheduler scheduler = TransferScheduler.getInstance();
    private ScheduleRequestLog scheduleRequestLog = ScheduleRequestLog.getInstance();
    private WireTransferFactory wireTransferFactory = new WireTransferFactory();
    private WireTransferProcessor wireTransferProcessor = new WireTransferProcessor();

    public ArrayList<String> getTxnIDs() throws IOException {
        String date = LocalDate.now().toString();
        HashMap<String, ArrayList<String>> log = scheduler.readLog();
        ArrayList<String> txnIDs = log.get(date);
        return txnIDs;
    }
    public WireTransfer createTransfer(AutoWireTransfer autoWireTransfer) throws IOException {
        String fromAccountID = autoWireTransfer.getFromAccountID();
        String toAccountID = autoWireTransfer.getToAccountID();
        String userID = autoWireTransfer.getUserID();
        double amount = autoWireTransfer.getAmount();
        WireTransfer wireTransfer = wireTransferFactory.createWire(userID, fromAccountID, toAccountID, amount);
        wireTransfer.setAutoTransferID(autoWireTransfer.getWireID());
        return wireTransfer;
    }

    public void processAutoTransfers() {
        try {
            ArrayList<String> txnIDs = getTxnIDs();
            scheduler.deleteDate(LocalDate.now().toString());
            for(String txnID : txnIDs) {
                AutoWireTransfer autoWire = scheduleRequestLog.getTransfer(txnID);
                autoWire.getAutoTransferID();
                if (autoWire.getApproval() == true) {
                    WireTransfer transfer = createTransfer(autoWire);
                    transfer.setAutoTransferID(autoWire.getWireID());
                    transfer.setRecurring(true);
                    wireTransferProcessor.processRequest(transfer);
                    updateAutoWire(autoWire,transfer);
                    logAutoWire(autoWire);

                }
            }
        } catch (Exception e) {
            System.out.println("No transactions found ");
        }
    }
    public void logAutoWire(AutoWireTransfer autoWireTransfer) throws IOException {
        scheduleRequestLog.logRequest(autoWireTransfer);

    }

    public void updateAutoWire(AutoWireTransfer autoWire, WireTransfer transfer) throws IOException {
        if (transfer.getFailureReason() != null) {
            autoWire.incrementConsecutiveFailures();
            freezeCheck(autoWire);
        }
        else{
            autoWire.resetConsecutiveFailures();
            autoWire.incrementNumTransfers();
        }
        if (autoWire.getApproval() != false){
            autoWire.setNextDate();
            scheduler.logObjectToDate(autoWire);
        }
        logAutoWire(autoWire);
    }
    public void freezeCheck(AutoWireTransfer autoWire) {
        if (autoWire.getConsecutiveFailures() >= 3) {
            autoWire.setApproval(false);
        }

    }
}
