package bank.transactions.wiretrasfer;

import bank.idtools.AutoTransferIDGenerator;
import bank.idtools.TransferIDGenerator;
import bank.idtools.UniqueIDGenerator;
import bank.transactions.auto.AutoWireTransfer;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class WireTransferFactory {
    private static final UniqueIDGenerator transferIDGenerator = new TransferIDGenerator();
    private static final UniqueIDGenerator autoTransferIDGenerator = new AutoTransferIDGenerator();

    // Factor for recurring wrapper
    public static AutoWireTransfer createWire(String userID, String fromAccountID, String toAccountID, double amount, String rate, String startDate) {
        String wireID = autoTransferIDGenerator.generateID();
        AutoWireTransfer transfer = new AutoWireTransfer.Builder()
                .wireID(wireID)
                .amount(amount)
                .fromAccountID(fromAccountID)
                .toAccountID(toAccountID)
                .fromUserID(userID)
                .recurring(true)
                .rate(rate)
                .nextDate(startDate)
                .build();
        transfer.setApproval(true);
        transfer.setTimestamp(LocalDate.now().toString());
        return transfer;
    }

    // Factory for single
    public static WireTransfer createWire(String userID, String fromAccountID, String toAccountID, double amount) {
        String wireID = transferIDGenerator.generateID();
        WireTransfer transfer = new WireTransfer.Builder()
                .wireID(wireID)
                .amount(amount)
                .fromAccountID(fromAccountID)
                .toAccountID(toAccountID)
                .fromUserID(userID)
                .recurring(false)
                .build();
        transfer.setTimestamp(LocalDateTime.now().toString());
        return transfer;
    }
}
