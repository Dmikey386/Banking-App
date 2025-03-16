package Bank.core.Transactions;

import Bank.account.BankAccount;
// Deposit object, add to transaction

public class WireTransfer {
    private BankAccount fromAccount;
    private BankAccount toAccount;
    private double amount;
    
    public WireTransfer(BankAccount fromAccount, BankAccount toAccount, double amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    public void wire() {
        // withdraw
        Withdraw withdrawal = new Withdraw(fromAccount, amount);
        withdrawal.process();

        // deposit
        Deposit deposit = new Deposit(toAccount, amount);
        deposit.process();
    }

}
