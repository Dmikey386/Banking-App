package Bank.automaticTransactions;

import Bank.IDTools.AutoTransactionIDGenerator;
import java.time.LocalDate;

public class AutoTransactionRequest {
    private String autoTransactionID;
    private String userID;
    private String[] accountIDs;
    private double amount;
    private int transactionType;
    private String rate;
    private String dateInitialized;
    private AutoTransactionIDGenerator autoTransactionIDGenerator = new AutoTransactionIDGenerator();


    public AutoTransactionRequest(Builder build) {
        this.userID = build.userID;
        this.accountIDs = build.accountIDs;
        this.amount = build.amount;
        this.rate = build.rate;
        this.transactionType = build.transactionType;
        this.dateInitialized = LocalDate.now().toString();
        this.autoTransactionID = autoTransactionIDGenerator.generateID();
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
