package Bank.account;

public class SavingsAccount extends BankAccount {
    //savings account
    double savingsAPY;

    //savings account constructor
    public SavingsAccount(int accountNumber,double APY){
        super(accountNumber);
        savingsAPY = APY;
    }

    @Override
    public double APY(){
        double yield = this.getBalance()*savingsAPY;
        this.deposit(yield);
        System.out.println("APY: " + (Math.round(yield * 100)/100.0) + " Total Balance: " + getBalance());
        return yield;
    }

    @Override
    public void printAccountInfo(){
        System.out.println("Account Type: Savings");
        System.out.println("Account #: " + getAccountNumber());
        System.out.println("Balance: " + getBalance());
    }

}