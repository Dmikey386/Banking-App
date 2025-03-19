package Bank.account;
/*
Object containing Transaction request info
 */

import java.util.Random;

public class TransactionRequest {
    private User user;
    private int[] accountIDs;
    private double amount;
    private int transactionType;
    private boolean status = false;
    private String transactionFailure = null;
    private String transactionID;


    // constructore for transaction request
    public TransactionRequest(Builder builder) {
        this.user = builder.user;
        this.accountIDs = builder.accountIDs;
        this.amount = builder.amount;
        this.transactionType= builder.transactionType;
        this.status = builder.status;
        this.setTransactionID();

    }


    // getters for transaction request
    public boolean getStatus(){
        return status;
    }
    public int[] getAccountIDs(){
        return accountIDs;
    }
    public int getTransactionType(){
        return transactionType;
    }
    public double getAmount(){
        return amount;
    }
    public User getUser(){
        return user;
    }
    public int getUserID(){
        return user.getUserID();
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
        Random rand = new Random();
        String transactionID = String.valueOf(rand.nextInt(10000));
        this.transactionID = transactionID;
    }
    public String getTransactionID(){

        return this.transactionID;
    }

    
    // Use Builder class for construction
    public static class Builder {
        private User user;
        private int[] accountIDs;
        private double amount;
        private int transactionType;
        private boolean status;


        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder accountIDs(int[] accountIDs) {
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

