package Bank.account;

public class BankAccount {
    private double balance;
    private int accountNumber;
    private TransactionLogger transactionManager; // Store transactions by account

    // Constructor
    public BankAccount(int accountNumber) {
        double balance = 0;
        this.accountNumber = accountNumber;
    }

    // getters
    public double getBalance(){
        return balance;
    }
    public int getAccountNumber(){
        return accountNumber;
    }
    public TransactionLogger getTransactionManager(){
        return transactionManager;
    }

    // Setters
    public void setBalance(double newBalance){
        balance = newBalance;
    }
}



