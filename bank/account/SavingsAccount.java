package bank.account;

public class SavingsAccount extends BankAccount {
    //savings account
    double savingsAPY;
    private int monthTxn;
    private int monthTxnLimit = 6;
    private static final String type = "Savings";

    // constructor
    public SavingsAccount(String accountID, String userID) {
        super(accountID, userID);
    }

    // setters
    public void setNumTxnLimit(int monthTxnLimit) {
        this.monthTxnLimit = monthTxnLimit;
    }
    public void incrementTxn(){
        monthTxn++;
    }
    public void setMonthTxn(int num){
        monthTxn = num;
    }

    // getters
    public int getMonthTxnLimit() {
        return monthTxnLimit;
    }
    public int getMonthTxn() {
        return monthTxn;
    }
    @Override
    public String getType(){
        return type;
    }

}