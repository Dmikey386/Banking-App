package Bank.transactions;

import Bank.account.BankAccount;


public interface Transaction{
    // Interface for key transaction methods
    void process();
    double getAmount();
    BankAccount[] getAccount();


}

 class Deposit implements Transaction {
     // Deposit money into an account
     private BankAccount account;
     private double amount;

     // constructor
     public Deposit(BankAccount[] account, double amount) {
         this.account = account[0];
         this.amount = amount;
     }

     // setters
     public void process() {
         account.setBalance(account.getBalance() + amount);
     }

     // getters
     public BankAccount[] getAccount() {
         return new BankAccount[]{account};
     }
     public double getAmount() {
         return amount;
     }
 }

 class Withdraw implements Transaction{
    // withdraw money from an account
    private BankAccount account;
    private double amount;

    // constructor
    public Withdraw(BankAccount[] account, double amount) {
        this.account = account[0];
        this.amount = amount;
    }

    // process withdrawal
    public void process(){
        account.setBalance(account.getBalance() - amount);
    }

    // getters
     public BankAccount[] getAccount() {
        return new BankAccount[]{account};
     }
    public double getAmount() {
        return amount;
    }

}

 class WireTransfer implements Transaction{
    // wire money from one account to another
    private BankAccount withdrawAcc;
    private BankAccount depositAcc;
    private double amount;


    // constructor
    public WireTransfer(BankAccount[] accounts, double amount) {
        this.withdrawAcc = accounts[0];
        this.depositAcc = accounts[1];
        this.amount = amount;
    }

    // getters
    public double getAmount() {
        return amount;
    }
    public BankAccount[] getAccount() {
        return new BankAccount[]{withdrawAcc, depositAcc};
    }


    // process withdraw
    public void process() {
        // withdraw
        Withdraw withdrawal = new Withdraw(new BankAccount[] {withdrawAcc}, amount);
        withdrawal.process();

        // deposit
        Deposit deposit = new Deposit(new BankAccount[] {depositAcc}, amount);
        deposit.process();
    }
}