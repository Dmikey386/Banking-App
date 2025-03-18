package Bank.core.transactions;

import Bank.account.BankAccount;


public interface Transaction{
    void process();
    double getAmount();
    int getTransactionID();
    BankAccount[] getAccount();


}

 class Deposit implements Transaction {
     // Deposit money into an account
     private BankAccount account;
     private double amount;
     private int transactionID;

     public Deposit(BankAccount[] account, double amount) {
         this.account = account[0];
         this.amount = amount;
     }

     // setters
     public void process() {
         account.setBalance(account.getBalance() + amount);
     }

     public BankAccount[] getAccount() {
         return new BankAccount[]{account};
     }
     public double getAmount() {
         return amount;
     }
     public int getTransactionID() {
         return transactionID;
     }
 }

 class Withdraw implements Transaction{
    private BankAccount account;
    private double amount;
    private int transactionID;

    public Withdraw(BankAccount[] account, double amount) {
        this.account = account[0];
        this.amount = amount;
    }

    // setters
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
     public int getTransactionID() {
         return transactionID;
     }

}

 class WireTransfer implements Transaction{
    private BankAccount withdrawAcc;
    private BankAccount depositAcc;
    private double amount;
    private int transactionID;

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
     public int getTransactionID() {
         return transactionID;
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