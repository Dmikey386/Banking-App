package bank.transactions.wiretrasfer;

import bank.idtools.TransferIDGenerator;
import bank.idtools.UniqueIDGenerator;

import java.time.LocalDateTime;


public class WireTransferFactory {
    private static final UniqueIDGenerator transferIDGenerator = new TransferIDGenerator();

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
