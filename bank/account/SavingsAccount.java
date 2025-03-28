package bank.account;

public class SavingsAccount extends BankAccount {
    //savings account
    double savingsAPY;

    //savings account constructor
    public SavingsAccount(String accountID,String userID) {
        super(accountID,userID);
    }

    // print account information
    public void printAccountInfo(){
        System.out.println("Account Type: Savings");
        System.out.println("Account #: " + getAccountID());
        System.out.println("Balance: " + getBalance());
    }

}