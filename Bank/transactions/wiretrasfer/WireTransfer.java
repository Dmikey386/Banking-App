package bank.transactions.wiretrasfer;

import java.io.IOException;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WireTransfer {
    private String wireID;
    private double amount;
    private String fromAccountID;
    private String toAccountID;
    private String fromUserID;
    private String timestamp;
    private boolean approval;
    private String failureReason = null;
    private String depositID;
    private String withdrawID;

    // store autotransaction data
    private boolean recurring;
    private String autoTransferID;

    // Private constructor
    public WireTransfer(WireTransfer.Builder builder) {
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
    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }
    public void setDepositID(String depositID) {
        this.depositID = depositID;
    }

    public void setWithdrawID(String withdrawID) {
        this.withdrawID = withdrawID;
    }

    public void setApproval(boolean approval) {
        this.approval = approval;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    public void setAutoTransferID(String autoTransferID) {
        this.autoTransferID = autoTransferID;
    }

    // getters
    public String getWireID() throws IOException {
        return wireID;
    }
    public boolean getRecurring() {
        return recurring;
    }
    public String getAutoTransferID() {
        return autoTransferID;
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
        return approval;
    }

    public String getWithdrawID() {
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
    public static class Builder<T extends Builder<T>> {
        protected String wireID;
        protected double amount;
        protected String fromAccountID;
        protected String toAccountID;
        protected String fromUserID;
        protected boolean recurring;

        public T wireID(String wireID) {
            this.wireID = wireID;
            return (T) this;
        }

        public T amount(double amount) {
            this.amount = amount;
            return (T) this;
        }

        public T fromAccountID(String fromAccountID) {
            this.fromAccountID = fromAccountID;
            return (T) this;
        }

        public T toAccountID(String toAccountID) {
            this.toAccountID = toAccountID;
            return (T) this;
        }

        public T fromUserID(String fromUserID) {
            this.fromUserID = fromUserID;
            return (T) this;
        }

        public T recurring(boolean recurring) {
            this.recurring = recurring;
            return (T) this;
        }

        public WireTransfer build() {
            return new WireTransfer(this);
        }
    }
}


