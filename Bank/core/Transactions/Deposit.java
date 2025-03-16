package Bank.core.Transactions;

import Bank.account.BankAccount;

public class Deposit {
    // deposit money from one account to another account
    private BankAccount account;
    private double amount;

    public Deposit(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    // setters
    public void process(){
        account.setBalance(account.getBalance() + amount);
    }

    // getters
    public BankAccount getAccount() {
        return account;
    }
    public double getAmount() {
        return amount;
    }
}
