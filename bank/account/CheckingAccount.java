package bank.account;

public class CheckingAccount extends BankAccount {
    // checking account
    double checkingAPY;

    // checking account constructor
    public CheckingAccount(String accountID, String userID) {
        super(accountID, userID);
    }

    // print account information
    public void printAccountInfo() {
        System.out.println("Account Type: Checking");
        System.out.println("Account #: " + getAccountID());
        System.out.println("Balance: " + getBalance());
    }

}
