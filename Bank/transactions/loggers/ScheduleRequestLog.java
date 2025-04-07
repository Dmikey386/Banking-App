package bank.transactions.loggers;

import bank.persistentstorage.JsonLogger;
import bank.transactions.auto.AutoWireTransfer;
import bank.transactions.wiretrasfer.WireTransferFactory;
import java.io.IOException;
import java.util.Map;

public class ScheduleRequestLog extends JsonLogger<AutoWireTransfer> {
        private static volatile ScheduleRequestLog single_instance = null;
        private WireTransferFactory wireTransferFactory = new WireTransferFactory();

        // wrapper for singleton
        public static ScheduleRequestLog getInstance() {
            // ensure only one instance
            if(single_instance == null){
                synchronized (ScheduleRequestLog.class) {
                    if(single_instance == null){
                        single_instance = new ScheduleRequestLog();
                    }
                }
            }
            return single_instance;
        }
        // constructor
        private ScheduleRequestLog() {
            super("Storage/recurringrequest.json");
        }

        public AutoWireTransfer getTransfer(String autoID) throws IOException {
            Map<String, Object> transfers = (Map<String, Object>) getObjectMap(autoID);
            double amount = (Double) transfers.get("amount");
            String fromAccountID = (String) transfers.get("fromAccountID");
            String toAccountID = (String) transfers.get("toAccountID");
            String timestamp = (String) transfers.get("timestamp");
            String userID = (String) transfers.get("userID");
            String wireID = (String) transfers.get("wireID");
            Boolean recurring = (Boolean) transfers.get("recurring");
            String rate = (String) transfers.get("rate");
            Boolean approval = (Boolean) transfers.get("approval");
            String nextDate = (String) transfers.get("nextDate");
            Integer numTransfers = (Integer) transfers.get("numTransfers");
            Integer consecutiveFailures = (Integer) transfers.get("consecutiveFailures");
            AutoWireTransfer transfer = new AutoWireTransfer.Builder()
                    .wireID(wireID)
                    .fromAccountID(fromAccountID)
                    .toAccountID(toAccountID)
                    .fromUserID(userID)
                    .nextDate(nextDate)
                    .recurring(recurring)
                    .amount(amount)
                    .rate(rate)
                    .build();
            transfer.setTimestamp(timestamp);
            transfer.setNumTransfers(numTransfers);
            transfer.setConsecutiveFailures(consecutiveFailures);
            transfer.setApproval(approval);

            return transfer;
        }
        public void logRequest(AutoWireTransfer auto) throws IOException {
            logObject(auto.getWireID(),auto);
        }
}

