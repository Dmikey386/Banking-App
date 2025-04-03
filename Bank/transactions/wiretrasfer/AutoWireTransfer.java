package bank.transactions.wiretrasfer;

public class AutoWireTransfer extends WireTransfer{
    private String rate;

    public AutoWireTransfer(String transferID, double amount, String fromAccountID, String toAccountID, String fromUserID, boolean recurring) {
        super(transferID, amount, fromAccountID, toAccountID, fromUserID, recurring);
    }
    public void setRate(String rate) {
        this.rate = rate;
    }
}
