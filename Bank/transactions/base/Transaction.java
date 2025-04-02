package bank.transactions.base;
import bank.account.AccountLogger;
import bank.idtools.TransactionIDGenerator;
import bank.transactions.loggers.TransactionLogger;
import bank.user.UserLogger;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.IOException;
import java.time.LocalDateTime;

@JsonIgnoreProperties({"verifier","idGenerator","accountLog","transactionLog","userLog"})
public abstract class Transaction {
    private String transactionID;
    private int amount;
    private String accountID;
    private String timestamp;
    private boolean approval = false;
    private String failureReason;

    protected UserLogger userLog = UserLogger.getInstance();
    protected AccountLogger accountLog = AccountLogger.getInstance();
    protected TransactionLogger transactionLog = TransactionLogger.getInstance();
    protected TransactionIDGenerator idGenerator = new TransactionIDGenerator();
    protected TransactionVerifier verifier = new TransactionVerifier();

    public Transaction(int amount, String accountID) {
        this.amount = amount;
        this.accountID = accountID;
        this.timestamp = LocalDateTime.now().toString();
        this.transactionID = idGenerator.generateID();
    }

    // Process
    public abstract void process() throws IOException;
    public abstract void logTransaction() throws IOException;
    public abstract void verifyTransaction();


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
    public int getAmount(){
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
