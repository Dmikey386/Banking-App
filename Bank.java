package MethodTesting;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class Bank {
    private double monetaryBase;
    private double checkingAPY;
    private double savingsAPY;
    // HashMap to store all accountsMap for fast lookup
    private HashMap<Integer, BankAccount> accountsMap = new HashMap<>();

    // Array to store account numbers for looping through all accountsMap faster than hash
    private ArrayList<Integer> accountNumsList = new ArrayList<>();

    // Bank Constructor
    Bank(double checkingAPY, double savingsAPY) {
        this.monetaryBase = 0;
        this.checkingAPY = checkingAPY;
        this.savingsAPY = savingsAPY;
    }

    // Getter methods
    // get individual account Do i still need this
    public BankAccount getAccount(int accountNumber){
        return accountsMap.get(accountNumber);
    }
    // get monetary base
    public double getMonetaryBase(){
        return this.monetaryBase;
    }

    // Setter methods
    // set new value to account database
    private void setAccountsDatabase(int accountNumber,BankAccount account){
        accountsMap.put(accountNumber, account);
        accountNumsList.add(accountNumber);
    }
    //set monetary base
    private void setMonetaryBase(){
        monetaryBase = 0;
        for (BankAccount account : accountsMap.values()) {
            monetaryBase += account.getBalance();
        }
    }



    // Open new account
    public int openAccount(String accountType){
        Random rand = new Random();

        // Check for valid account number
        int accountNumber = rand.nextInt(1000);
        while (accountsMap.containsKey(accountNumber)){
            accountNumber = rand.nextInt(1000);
        }

        // Make account
        switch (accountType){
            case "Checking":
                CheckingAccount newChecking = new CheckingAccount(accountNumber, checkingAPY);
                setAccountsDatabase(accountNumber,newChecking);
                break;
            case "Savings":
                SavingsAccount newSavings = new SavingsAccount(accountNumber,savingsAPY);
                setAccountsDatabase(accountNumber,newSavings);
                break;
            default: // would not occur if there was a button to pick
                System.out.println("Invalid account type");
                break;
        }

        return accountNumber;
    }

    // Transactional info
    // Deposit function
    public void deposit(int accountNum, double amount) {
        System.out.println("Deposited " + amount + " to account #" + accountNum);
        setMonetaryBase();
        accountsMap.get(accountNum).deposit(amount);
    }

    // Withdraw function
    public void withdraw(int accountNum, double amount) {
        System.out.println("Action: Withdrawn " + amount + " to account #" + accountNum);
        setMonetaryBase();
        accountsMap.get(accountNum).withdraw(amount);
    }
    // Transfer function
    public void transfer(int sender, int receiver, double amount) {
        System.out.println("Action: Transferred " + amount + " from account #" + sender + " to account #" + receiver);
        accountsMap.get(sender).transfer(this.accountsMap.get(receiver), amount);
    }

    // APY function
    public void updateAPY(){
        for (Integer accountNum : accountNumsList){
            double yield = getAccount(accountNum).APY();
        }
        setMonetaryBase();
    }

}
