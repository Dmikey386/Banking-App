package bank.account;

public class BankAccount {
    private double balance;
    private String accountID;
    private String userID;

    //Constructor
    public BankAccount(String accountID, String userID, double balance) {
        this.accountID = accountID;
        this.balance = balance;
        this.userID = userID;
    }
    // Constructor Wrapper
    public BankAccount(String accountID, String userID) {
        this.userID = userID;
        double balance = 0;
        this.accountID = accountID;
    }

    // getters
    public double getBalance(){
        return balance;
    }
    public String getAccountID(){
        return accountID;
    }
    public String getUserID(){
        return userID;
    }
    // Setters
    public void setBalance(double newBalance){
        balance = newBalance;
    }

}




