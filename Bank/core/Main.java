package Bank.core;

import Bank.account.BankAccount;
import Bank.account.User;
import Bank.core.Transactions.Deposit;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        User user1 = new User(1);
        int acc1 = user1.openAccount("Savings");
        int acc2 = user1.openAccount("Checking");



    }
}
