package Bank.automaticTransactions;

import java.io.IOException;

public class AutoTransaction {
    protected String autoTransactionID;
    protected String userID;
    protected String[] accountIDs;
    protected boolean active;
    protected int transactionType;
    protected double amount;
    protected String rate;



    public AutoTransaction(String[] accountIDs, String rate, double amount) {
        this.amount = amount;
        this.rate = rate;
        this.accountIDs = accountIDs;
    }


}
