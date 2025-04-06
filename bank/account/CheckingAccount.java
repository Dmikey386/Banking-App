package bank.account;

import java.time.LocalDate;
import java.time.YearMonth;

public class CheckingAccount extends BankAccount {
    // checking account
    double checkingAPY;
    private double monthlyLimit = -1; // default no limit
    private double dailyLimit = -1; // default no limit
    private double daySpending;
    private double monthSpending;
    private static final String type = "Checking";
    private LocalDate lastDayReset = LocalDate.now();
    private YearMonth lastMonthReset = YearMonth.now();


    // Constructor
    public CheckingAccount(String accountID, String userID) {
        super(accountID, userID);
    }

    @Override
    // reset at end of month and end of day
    public void checkAndResetLimits() {
        LocalDate today = LocalDate.now();

        if (!today.equals(lastDayReset)) {
            setDaySpending(0);
            lastDayReset = today;
        }

        YearMonth thisMonth = YearMonth.now();
        if (!thisMonth.equals(lastMonthReset)) {
            setMonthSpending(0);
            lastMonthReset = thisMonth;
        }
    }

    // setters
    public void setLastDayReseet(LocalDate lastDayReset) {
        this.lastDayReset = lastDayReset;
    }
    public void setLastMonthReset(YearMonth lastMonthReset) {
        this.lastMonthReset = lastMonthReset;
    }
    public void setMonthlyLimit(double monthlyLimit) {
        this.monthlyLimit = monthlyLimit;
    }
    public void setDailyLimit(double dailyLimit) {
        this.dailyLimit = dailyLimit;
    }
    public void addToSpending(double amount) {
        monthSpending += amount;
        daySpending += amount;
    }
    public void setMonthSpending(double limit) {
        monthSpending = limit;
    }
    public void setDaySpending(double limit) {
        daySpending = limit;
    }

    //getters
    public double getMonthlyLimit() {
        return monthlyLimit;
    }
    public double getDailyLimit() {
        return dailyLimit;
    }
    public double getMonthSpending() {
        return monthSpending;
    }
    public double getDaySpending() {
        return daySpending;
    }
    @Override
    public String getType(){
        return type;
    }

}
