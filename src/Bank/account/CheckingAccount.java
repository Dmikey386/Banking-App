package Bank.account;

public class CheckingAccount extends BankAccount {
    // checking account
    double checkingAPY;

    // checking account constructor
    CheckingAccount(int accountNumber, double APY) {
        super(accountNumber);
        checkingAPY = APY;
    }

    // Savings APY
    @Override
    public double APY(){
        double yield = getBalance()*checkingAPY;
        this.deposit(yield);
        System.out.println("APY: " + (Math.round(yield * 100)/100.0) + " Total Balance: " + getBalance());
        return yield;
    }

    @Override
    public void printAccountInfo() {
        System.out.println("Account Type: Checking");
        System.out.println("Account #: " + getAccountNumber());
        System.out.println("Balance: " + getBalance());
    }

}
