package Bank.transactions.transactionProcessing.single;

import Bank.IDTools.TransactionIDGenerator;
import Bank.IDTools.UniqueIDGenerator;

public class TransactionRequest {
    private String userID;
    private String[] accountIDs;
    private double amount;
    private int transactionType;
    private boolean status = false;
    private boolean auto;
    private String transactionFailure = null;
    private String transactionID;
    private final UniqueIDGenerator transactionIDGenerator = new TransactionIDGenerator();


    // constructore for transaction request
    public TransactionRequest(Builder builder) {
        this.userID = builder.userID;
        this.accountIDs = builder.accountIDs;
        this.amount = builder.amount;
        this.transactionType= builder.transactionType;
        this.status = builder.status;
        this.auto = builder.auto;
        this.setTransactionID();
    }


    // getters for transaction request
    public boolean getStatus(){
        return status;
    }
    public String[] getAccountIDs(){
        return accountIDs;
    }
    public int getTransactionType(){
        return transactionType;
    }
    public double getAmount(){
        return amount;
    }
    public String getUserID(){
        return userID;
    }
    public String getTransactionID(){
        return this.transactionID;
    }



    // set status of transaction
    public void setStatus(boolean status) {
        this.status = status;
    }
    public void setFailureStatement(String message){
        transactionFailure = message;
    }
    public String getFailureStatement(){
        return transactionFailure;
    }
    public void setTransactionID() {
        this.transactionID = transactionIDGenerator.generateID();
    }


    
    // Use Builder class for construction
    public static class Builder {
        private String userID;
        private String[] accountIDs;
        private double amount;
        private int transactionType;
        private boolean status;
        private boolean auto;

        public Builder auto(boolean auto) {
            this.auto = auto;
            return this;
        }

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

        public Builder status(boolean status) {
            this.status = status;
            return this;
        }

        public TransactionRequest build() {
            return new TransactionRequest(this);
        }
    }


}

