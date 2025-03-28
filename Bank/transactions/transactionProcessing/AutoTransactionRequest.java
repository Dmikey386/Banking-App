package Bank.transactions.transactionProcessing;

import java.time.LocalDate;

public class AutoTransactionRequest {
    private String autoTransactionID;
    private String userID;
    private String[] accountIDs;
    private double amount;
    private int transactionType;
    private String rate;
    private String dateRequested;
    private boolean verified = false;
    private String failureReason = null;


    public AutoTransactionRequest(Builder build) {
        this.userID = build.userID;
        this.accountIDs = build.accountIDs;
        this.amount = build.amount;
        this.rate = build.rate;
        this.transactionType = build.transactionType;
        this.dateRequested = LocalDate.now().toString();
    }
    // Get Transaction
    public String getAutoTransactionID() {
        return autoTransactionID;
    }
    public int getTransactionType() {
        return transactionType;
    }
    public String[] getAccountIDs() {
        return accountIDs;
    }
    public double getAmount() {
        return amount;
    }
    public String getRate(){
        return rate;
    }
    public String getdateRequested(){
        return dateRequested;
    }
    public String getUserID(){
        return userID;
    }
    public boolean getVerification(){
        return verified;
    }
    public String getFailureReason(){
        return failureReason;
    }
    
    //set verification
    public void setVerification(boolean verified){
        this.verified = verified;
    }
    public void setFailureReason(String failureReason){
        this.failureReason = failureReason;
    }


    // Use Builder class for construction
    public static class Builder {
        private String userID;
        private String[] accountIDs;
        private double amount;
        private int transactionType;
        private String rate;



        public Builder userID(String userID) {
            this.userID = userID;
            return this;
        }

        public Builder accountIDs(String[] accountIDs) {
            this.accountIDs = accountIDs;
            return this;
        }

        public Builder amount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder transactionType(int transactionType) {
            this.transactionType = transactionType;
            return this;
        }

        public Builder rate(String rate) {
            this.rate = rate;
            return this;
        }

        public AutoTransactionRequest build() {
            return new AutoTransactionRequest(this);
        }
    }
}
