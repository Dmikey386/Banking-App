package MethodTesting;

public class BankAccount {
    private double balance;
    private int accountNumber;

    // Constructor
    public BankAccount(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    //setters
    private void setBalance(double newBalance){
        this.balance = newBalance;
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

    // Transactions
    // deposit
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }
    // transfer
    public void transfer(BankAccount recipient, double amount){
        if (amount > getBalance()){
            System.out.println("Insufficient Balance");
        }
        else{
            setBalance(getBalance() - amount);
            recipient.deposit(amount);
        }
    }
    // withdraw
    public void withdraw(double amount) {
        if (amount > getBalance()) {
            System.out.println("Insufficient Balance");
        }
        else{
            setBalance(getBalance() - amount);
        }
    }

    // APY
    public double APY(){
        //calculate APY yield, deposit to account
        return 0.0;
    }

    // print account information
    public void printAccountInfo(){
        //Account info

    }

}



