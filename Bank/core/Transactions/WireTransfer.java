package Bank.core.Transactions;

import Bank.account.BankAccount;

public class WireTransfer {
    private BankAccount withdrawAcc;
    private BankAccount depositAcc;
    private double amount;
    
    public WireTransfer(BankAccount depositAcc, BankAccount withdrawAcc, double amount) {
        this.withdrawAcc = withdrawAcc;
        this.depositAcc = depositAcc;
        this.amount = amount;
    }

    public void process() {
        // withdraw
        Withdraw withdrawal = new Withdraw(withdrawAcc, amount);
        withdrawal.process();

        // deposit
        Deposit deposit = new Deposit(depositAcc, amount);
        deposit.process();
    }

}
