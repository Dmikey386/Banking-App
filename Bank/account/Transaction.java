package Bank.account;

public class Transaction{
    private int depositAccount;
    private int withdrawAccount;
    private int transactionType;
    private double amount;

    // Core transaction constructor
    public Transaction(int depositAccount, int withdrawAccount,int transactionType, double amount) {
        this.depositAccount = depositAccount;
        this.withdrawAccount = withdrawAccount;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    // getters
    public int getdepositAccount() {
        return depositAccount;
    }
    public int getwithdrawAccount() {
        return withdrawAccount;
    }
    public int getTransactionType() {
        return transactionType;
    }
    public double getAmount() {
        return amount;
    }
}
