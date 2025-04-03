package bank.account;

public class CheckingAccount extends BankAccount {
    // checking account
    double checkingAPY;
    private double monthlyLimit;
    private double dailyLimit;
    private double daySpending;
    private double monthSpending;
    private static final String type = "Checking";



    // Constructor
    public CheckingAccount(String accountID, String userID) {
        super(accountID, userID);
    }

    // setters
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
    public void setMonthSpending(double amount) {
        monthSpending = amount;
    }
    public void setDaySpending(double amount) {
        daySpending = amount;
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
    public double getDailySpending() {
        return daySpending;
    }
    @Override
    public String getType(){
        return type;
    }

}
