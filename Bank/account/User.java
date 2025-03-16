package Bank.account;
import java.util.Random;
import java.util.HashMap;
import java.util.ArrayList;

public class User {
    private int userID;
    private HashMap<Integer, BankAccount> userAccMap = new HashMap<>();
    private ArrayList<Integer> userAccList = new ArrayList<>();
    private double totalBalance;

    //User Constructor
    public User(int userID){
        this.userID = userID;
        totalBalance = 0;
    }

    // set new value to account database
    private void addAccToUser(int accountNumber, BankAccount account) {
        userAccMap.put(accountNumber, account);
        userAccList.add(accountNumber);
    }

    // Open new account
    public int openAccount(String accountType) {
        Random rand = new Random();

        // Check for valid account number in database
        int accountNumber = rand.nextInt(1000);

        // Make account
        switch (accountType) {
            case "Checking":
                CheckingAccount newChecking = new CheckingAccount(accountNumber);
                addAccToUser(accountNumber, newChecking);
                break;
            case "Savings":
                SavingsAccount newSavings = new SavingsAccount(accountNumber);
                addAccToUser(accountNumber, newSavings);
                break;
            default: // would not occur if there was a button to pick
                System.out.println("Invalid account type");
                break;
        }
        return accountNumber;
    }
}
