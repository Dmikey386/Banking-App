package Bank.core;

import Bank.account.TransactionRequest;
import Bank.account.User;

public class Main {
    public static void main(String[] args) {


        Bank bank = new Bank();
        bank.createUser(1);
        bank.createUser(2);
        int savings1 = bank.openAccount("Savings",bank.getUser(1));
        int savings2 = bank.openAccount("Checking",bank.getUser(2));
        int checking1 = bank.openAccount("Savings",bank.getUser(1));
        int checking2 = bank.openAccount("Checking",bank.getUser(2));


        // ===============================
//        DEPOSIT TESTS
// ===============================
        System.out.println("\n===== STARTING DEPOSIT TESTS =====\n");

// Savings Deposits
        System.out.println("Initial Savings Balances:");
        System.out.println("User 1 Savings: " + bank.getAccount(savings1).getBalance());
        System.out.println("User 2 Savings: " + bank.getAccount(savings2).getBalance());

        TransactionRequest depositSavings1 = bank.getUser(1).createTransactionRequest(new int[]{savings1}, 10000, 0);
        TransactionRequest depositSavings2 = bank.getUser(2).createTransactionRequest(new int[]{savings2}, 10000, 0);

        bank.processTransaction(depositSavings1);
        bank.processTransaction(depositSavings2);

        System.out.println("After Deposit Savings Balances:");
        System.out.println("User 1 Savings: " + bank.getAccount(savings1).getBalance());
        System.out.println("User 2 Savings: " + bank.getAccount(savings2).getBalance());

// Checking Deposits
        System.out.println("\nInitial Checking Balances:");
        System.out.println("User 1 Checking: " + bank.getAccount(checking1).getBalance());
        System.out.println("User 2 Checking: " + bank.getAccount(checking2).getBalance());

        TransactionRequest depositChecking1 = bank.getUser(1).createTransactionRequest(new int[]{checking1}, 10000, 0);
        TransactionRequest depositChecking2 = bank.getUser(2).createTransactionRequest(new int[]{checking2}, 10000, 0);

        bank.processTransaction(depositChecking1);
        bank.processTransaction(depositChecking2);

        System.out.println("After Deposit Checking Balances:");
        System.out.println("User 1 Checking: " + bank.getAccount(checking1).getBalance());
        System.out.println("User 2 Checking: " + bank.getAccount(checking2).getBalance());


// ===============================
//       WITHDRAWAL TESTS
// ===============================
        System.out.println("\n===== STARTING WITHDRAWAL TESTS =====\n");

// Savings Withdrawals
        TransactionRequest withdrawSavings1 = bank.getUser(1).createTransactionRequest(new int[]{savings1}, 5000, 1);
        TransactionRequest withdrawSavings2 = bank.getUser(2).createTransactionRequest(new int[]{savings2}, 5000, 1);

        bank.processTransaction(withdrawSavings1);
        bank.processTransaction(withdrawSavings2);

        System.out.println("After Withdrawal Savings Balances:");
        System.out.println("User 1 Savings: " + bank.getAccount(savings1).getBalance());
        System.out.println("User 2 Savings: " + bank.getAccount(savings2).getBalance());

// Checking Withdrawals
        TransactionRequest withdrawChecking1 = bank.getUser(1).createTransactionRequest(new int[]{checking1}, 5000, 1);
        TransactionRequest withdrawChecking2 = bank.getUser(2).createTransactionRequest(new int[]{checking2}, 5000, 1);

        bank.processTransaction(withdrawChecking1);
        bank.processTransaction(withdrawChecking2);

        System.out.println("After Withdrawal Checking Balances:");
        System.out.println("User 1 Checking: " + bank.getAccount(checking1).getBalance());
        System.out.println("User 2 Checking: " + bank.getAccount(checking2).getBalance());


// ===============================
//       TRANSFER TESTS
// ===============================
        System.out.println("\n===== STARTING TRANSFER TESTS =====\n");

// Transfer from User 1's Savings → Checking
        TransactionRequest transferToChecking1 = bank.getUser(1).createTransactionRequest(new int[]{savings1, checking1}, 2500, 2);
        bank.processTransaction(transferToChecking1);

// Transfer from User 2's Savings → Checking
        TransactionRequest transferToChecking2 = bank.getUser(2).createTransactionRequest(new int[]{savings2, checking2}, 2500, 2);
        bank.processTransaction(transferToChecking2);

        System.out.println("After Transfer (Savings to Checking):");
        System.out.println("User 1 Savings: " + bank.getAccount(savings1).getBalance());
        System.out.println("User 1 Checking: " + bank.getAccount(checking1).getBalance());
        System.out.println("User 2 Savings: " + bank.getAccount(savings2).getBalance());
        System.out.println("User 2 Checking: " + bank.getAccount(checking2).getBalance() + "\n");

// Transfer from User 1's Checking → User 2's Checking
        TransactionRequest transferCheckingToChecking = bank.getUser(1).createTransactionRequest(new int[]{checking1, checking2}, 3000, 2);
        bank.processTransaction(transferCheckingToChecking);

        System.out.println("After Transfer (Checking1 → Checking2):");
        System.out.println("User 1 Checking: " + bank.getAccount(checking1).getBalance());
        System.out.println("User 2 Checking: " + bank.getAccount(checking2).getBalance() + "\n");

// Transfer from User 1's Savings → User 2's Savings
        TransactionRequest transferSavingsToSavings = bank.getUser(1).createTransactionRequest(new int[]{savings1, savings2}, 3000, 2);
        bank.processTransaction(transferSavingsToSavings);

        System.out.println("After Transfer (Savings1 → Savings2):");
        System.out.println("User 1 Savings: " + bank.getAccount(savings1).getBalance());
        System.out.println("User 2 Savings: " + bank.getAccount(savings2).getBalance() + "\n");

// Transfer from User 1's Savings → User 2's Checking (FIXED ERROR)
        TransactionRequest transferSavingsToChecking = bank.getUser(1).createTransactionRequest(new int[]{savings1, checking2}, 3000, 2);
        bank.processTransaction(transferSavingsToChecking);

        System.out.println("After Transfer (Savings1 → Checking2):");
        System.out.println("User 1 Savings: " + bank.getAccount(savings1).getBalance());
        System.out.println("User 2 Checking: " + bank.getAccount(checking2).getBalance());




    }
}
