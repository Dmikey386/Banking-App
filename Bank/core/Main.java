package Bank.core;

import Bank.account.BankAccount;
import Bank.account.Transaction;
import Bank.account.TransactionManager;
import Bank.account.User;
import Bank.core.Transactions.Deposit;
import Bank.core.Transactions.ProcessTransactions;
import Bank.core.Transactions.WireTransfer;
import Bank.core.Transactions.Withdraw;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        User user1 = new User(1);
        int acc1ID = user1.openAccount("Savings");
        int acc2ID = user1.openAccount("Checking");
        BankAccount acc1 = user1.getAccount(acc1ID);
        BankAccount acc2 = user1.getAccount(acc2ID);
        System.out.println(acc1);
        Transaction deposit = new Transaction(acc1ID,0, 0,50000);
        Transaction withdraw = new Transaction(acc1ID,acc1ID, 1,25000);
        Transaction transfer = new Transaction(acc2ID,acc1ID, 2,12500);


        ProcessTransactions processDeposit = new ProcessTransactions(deposit,user1);
        processDeposit.processTransaction();
        System.out.println(acc1.getBalance());
        System.out.println(acc2.getBalance());
        ProcessTransactions processWithdraw = new ProcessTransactions(withdraw,user1);
        processWithdraw.processTransaction();
        System.out.println(acc1.getBalance());
        System.out.println(acc2.getBalance());
        ProcessTransactions processTransfer = new ProcessTransactions(transfer,user1);
        processTransfer.processTransaction();

        System.out.println(acc1.getBalance());
        System.out.println(acc2.getBalance());


    }
}
