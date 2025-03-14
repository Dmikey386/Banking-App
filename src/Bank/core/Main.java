package Bank.core;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank(0.005,0.035);

        // Open accounts
        System.out.println("Account creation");
        int accNum1 = bank.openAccount("Savings");
        int accNum2 =  bank.openAccount("Checking");
        System.out.println(" ");

        // Deposit into accounts
        bank.deposit(accNum1,1000);
        bank.deposit(accNum2,1000);

        //Withdraw more than possible
        bank.withdraw(accNum1,50000);
        bank.withdraw(accNum2,50000);

        //Transfer more than possible
        bank.transfer(accNum1,accNum2,25000);

        //withdraw
        bank.withdraw(accNum2,500);

        //transfer
        bank.transfer(accNum2,accNum1,250);

        //APY
        bank.updateAPY();


    }
}
