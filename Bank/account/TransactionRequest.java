package Bank.account;
/*
Object containing Transaction request info
 */

public class TransactionRequest {
    private User user;
    private int[] accountIDs;
    private double amount;
    private int transactionType;
    private boolean status;


    // constructore for transaction request
    public TransactionRequest(Builder builder) {
        this.user = builder.user;
        this.accountIDs = builder.accountIDs;
        this.amount = builder.amount;
        this.transactionType= builder.transactionType;
        this.status = builder.status;
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


    // set status of transaction
    public void setStatus(boolean status) {
        this.status = status;
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

