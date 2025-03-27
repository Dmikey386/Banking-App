package Bank.automaticTransactions;

import Bank.account.*;
import Bank.user.*;
import Bank.core.Bank;
import java.io.IOException;

public class AutoTransaction {
    protected boolean active;
    protected double amount;
    protected String rate; //Daily,Weekly,Monthly
    // next payment date
    protected int numPayments = 0;
    protected String[] accountIDs;
    protected Bank bank;


    public AutoTransaction(Bank bank, String rate, String[] accountIDs, double amount) {
        this.amount = amount;
        this.rate = rate;
        this.accountIDs = accountIDs;
    }

    public void process() throws IOException {
        // send payment
        // Create transaction request
        // Process Transaction Request

        //Update Bank Data
        incrementNumPayments();
        setNextDate();
        updateLogs();
    }

    public void setNextDate(){

    }
    public void incrementNumPayments(){
        numPayments++;
    }

    public void updateLogs(){
        // update AutoTransactionLog --> Next payment, num payments, failure updates: active, failure reason
        // update TransactionLog --> w request
        // update Account Balances
    }

}
