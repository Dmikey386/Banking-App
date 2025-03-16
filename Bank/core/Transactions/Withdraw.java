package Bank.core.Transactions;

import Bank.account.BankAccount;

public class Withdraw  {
    private BankAccount account;
    private double amount;

    public Withdraw(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    // setters
    public void process(){
        account.setBalance(account.getBalance() - amount);
    }

    // getters
    public BankAccount getAccount() {
        return account;
    }
    public double getAmount() {
        return amount;
    }
}
