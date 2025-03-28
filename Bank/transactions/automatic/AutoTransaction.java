package bank.transactions.automatic;

import java.io.IOException;

public class AutoTransaction {
    protected String autoTransactionID;
    protected String userID;
    protected String[] accountIDs;
    protected boolean active = false;
    protected int transactionType;
    protected double amount;
    protected String rate;
    protected String nextPaymentDate = null;



    public String getAutoTransactionID() {
        return autoTransactionID;
    }
    public AutoTransaction(AutoTransactionRequest autoTransactionRequest) {
        createAutoTransaction(autoTransactionRequest);
    }

    public void createAutoTransaction(AutoTransactionRequest autoTransactionRequest) {
        autoTransactionID = autoTransactionRequest.getAutoTransactionID();
        userID = autoTransactionRequest.getUserID();
        accountIDs = autoTransactionRequest.getAccountIDs();
        rate = autoTransactionRequest.getRate();
        transactionType = autoTransactionRequest.getTransactionType();
        amount = autoTransactionRequest.getAmount();
    }

    public void process() throws IOException {

    }

    public void setNextPaymentDate() {

    }



}
