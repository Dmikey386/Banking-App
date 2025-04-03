package bank.transactions.wiretrasfer;

import java.io.IOException;

public class WireTransfer {
    private String transferID;
    private double amount;
    private String fromAccountID;
    private String toAccountID;
    private String fromUserID;
    private boolean recurring;

    // Constructor
    public WireTransfer(String transferID, double amount, String fromAccountID, String toAccountID, String fromUserID, boolean recurring) {
        this.transferID = transferID;
        this.amount = amount;
        this.fromAccountID = fromAccountID;
        this.toAccountID = toAccountID;
        this.fromUserID = fromUserID;
        this.recurring = recurring;
    }
    public String getTransferID() throws IOException {
        return transferID;
    }

}
