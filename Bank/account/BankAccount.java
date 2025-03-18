package Bank.account;

public class BankAccount {
    private double balance;
    private int accountNumber;
    private TransactionManager transactionManager; // Store transactions by account

    // Constructor
    public BankAccount(int accountNumber) {
        double balance = 0;
        this.accountNumber = accountNumber;
    }

    // getters
    // return the current balance
    public double getBalance(){
        return balance;
    }
    // get account number
    public int getAccountNumber(){
        return accountNumber;
    }

    // Setters
    public void setBalance(double newBalance){
        balance = newBalance;
    }
}



