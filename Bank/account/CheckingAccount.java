package Bank.account;

public class CheckingAccount extends BankAccount {
    // checking account
    double checkingAPY;

    // checking account constructor
    public CheckingAccount(int accountNumber) {
        super(accountNumber);
    }

    // print account information
    public void printAccountInfo() {
        System.out.println("Account Type: Checking");
        System.out.println("Account #: " + getAccountNumber());
        System.out.println("Balance: " + getBalance());
    }

}
