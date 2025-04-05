package bank.transactions.wiretrasfer;

import java.io.IOException;

public class WireTransfer {
    private String wireID;
    private double amount;
    private String fromAccountID;
    private String toAccountID;
    private String fromUserID;
    private boolean recurring;
    private String timestamp;
    private boolean approved = false;
    private String failureReason = null;
    private String depositID;
    private String withdrawID;

    // Private constructor
    private WireTransfer(WireTransfer.Builder builder) {
        this.wireID = builder.wireID;
        this.amount = builder.amount;
        this.fromAccountID = builder.fromAccountID;
        this.toAccountID = builder.toAccountID;
        this.fromUserID = builder.fromUserID;
        this.recurring = builder.recurring;
    }
    // setters
    public void setFailureReason(String message) {
        failureReason = message;
    }
    public void setDepositID(String depositID) {
        this.depositID = depositID;
    }
    public void setWithdrawID(String withdrawID) {
        this.withdrawID = withdrawID;
    }
    public void setApproval(boolean approval) {
        this.approved = approval;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    // getters
    public String getTransferID() throws IOException {
        return wireID;
    }
    public String getUserID() throws IOException {
        return fromUserID;
    }
    public double getAmount() {
        return amount;
    }
    public String getFromAccountID() {
        return fromAccountID;
    }
    public String getToAccountID() {
        return toAccountID;
    }
    public boolean getApproval() {
        return approved;
    }
    public String getWithdrawID(){
        return withdrawID;
    }
    public String getDepositID() {
        return depositID;
    }
    public String getTimestamp() {
        return timestamp;
    }
    public String getFailureReason() {
        return failureReason;
    }


// Builder class
public static class Builder {
    private String wireID;
    private double amount;
    private String fromAccountID;
    private String toAccountID;
    private String fromUserID;
    private boolean recurring = false; // default

        public Builder wireID(String wireID) {
            this.wireID = wireID;
            return this;
        }

        public Builder amount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder fromAccountID(String fromAccountID) {
            this.fromAccountID = fromAccountID;
            return this;
        }

        public Builder toAccountID(String toAccountID) {
            this.toAccountID = toAccountID;
            return this;
        }

        public Builder fromUserID(String fromUserID) {
            this.fromUserID = fromUserID;
            return this;
        }

        public Builder recurring(boolean recurring) {
            this.recurring = recurring;
            return this;
        }

        public WireTransfer build() {
            return new WireTransfer(this);
        }
    }
}


