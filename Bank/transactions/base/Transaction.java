package bank.transactions.base;
import bank.account.AccountLogger;
import bank.idtools.TransactionIDGenerator;
import bank.transactions.loggers.TransactionLogger;
import bank.user.UserLogger;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.IOException;
import java.time.LocalDateTime;

@JsonIgnoreProperties({"accountLog","userLog"})
public abstract class Transaction {
    private String transactionID;
    private double amount;
    private String accountID;
    private String timestamp;
    private boolean approval = false;
    private String failureReason;
    protected UserLogger userLog = UserLogger.getInstance();
    protected AccountLogger accountLog = AccountLogger.getInstance();


    public Transaction(String transactionID, double amount, String accountID) {
        this.amount = amount;
        this.accountID = accountID;
        this.timestamp = LocalDateTime.now().toString();
        this.transactionID = transactionID;
    }

    // Process
    public abstract void process() throws IOException;

    // Setters
    public void setApproval(boolean approval) {
        this.approval = approval;
    }
    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    //getters
    public String getTransactionID(){
        return transactionID;
    }
    public double getAmount(){
        return amount;
    }
    public String getType(){
        return "Transaction";
    }
    public String getAccountID(){
        return accountID;
    }
    public String getTimestamp(){
        return timestamp;
    }
    public boolean getApproval(){
        return approval;
    }
    public String getFailureReason(){
        return failureReason;
    }

}
