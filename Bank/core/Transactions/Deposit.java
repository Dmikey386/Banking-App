package Bank.core.Transactions;

import Bank.account.BankAccount;

public class Deposit {
    // deposit money from one account to another account
    private int transactionID = 0;
    private BankAccount account;
    private double amount;

    public Deposit(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    // setters
    public void process(){
        System.out.println(account);
        account.setBalance(account.getBalance() + amount);
    }

    // getters
    public BankAccount getAccount() {
        return account;
    }
    public double getAmount() {
        return amount;
    }
    public int getTransactionID() {
        return transactionID;
    }
}
