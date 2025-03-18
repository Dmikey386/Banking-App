package Bank.account;

public class SavingsAccount extends BankAccount {
    //savings account
    double savingsAPY;

    //savings account constructor
    public SavingsAccount(int accountNumber){
        super(accountNumber);
    }

    public void printAccountInfo(){
        System.out.println("Account Type: Savings");
        System.out.println("Account #: " + getAccountNumber());
        System.out.println("Balance: " + getBalance());
    }

}