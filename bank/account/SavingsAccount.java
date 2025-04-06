package bank.account;

import java.time.LocalDate;
import java.time.YearMonth;

public class SavingsAccount extends BankAccount {
    //savings account
    double savingsAPY;
    private int monthTxn;
    private int monthTxnLimit = 6; // default limit
    private static final String type = "Savings";
    private YearMonth lastMonthReset = YearMonth.now();

    // constructor
    public SavingsAccount(String accountID, String userID) {
        super(accountID, userID);
    }

    @Override
    // reset at end of month and end of day
    public void checkAndResetLimits() {
        YearMonth thisMonth = YearMonth.now();
        if (!thisMonth.equals(lastMonthReset)) {
            setMonthTxn(0);
            lastMonthReset = thisMonth;
        }
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
    public void setLastMonthReset(YearMonth lastMonthReset) {
        this.lastMonthReset = lastMonthReset;
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