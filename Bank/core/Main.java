package Bank.core;

import Bank.account.TransactionRequest;
import Bank.account.User;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();
        bank.createUser(1);
        bank.createUser(2);
        int savings1 = bank.openAccount("Savings", bank.getUser(1));
        int savings2 = bank.openAccount("Checking", bank.getUser(2));
        int checking1 = bank.openAccount("Savings", bank.getUser(1));
        int checking2 = bank.openAccount("Checking", bank.getUser(2));

        // ===============================
        // DEPOSIT TESTS
        // ===============================
        System.out.println("\n===== STARTING DEPOSIT TESTS =====\n");

        TransactionRequest depositSavings1 = bank.getUser(1).createTransactionRequest(new int[]{savings1}, 10000, 0);
        TransactionRequest depositSavings2 = bank.getUser(2).createTransactionRequest(new int[]{savings2}, 10000, 0);
        TransactionRequest depositInvalidAccount = bank.getUser(1).createTransactionRequest(new int[]{9999}, 5000, 0); // Should fail

        bank.processTransaction(depositSavings1);
        bank.processTransaction(depositSavings2);
        bank.processTransaction(depositInvalidAccount);

        System.out.println("User 1 Savings Balance: " + bank.getAccount(savings1).getBalance());
        System.out.println("User 2 Savings Balance: " + bank.getAccount(savings2).getBalance());

        // ===============================
        // WITHDRAWAL TESTS (Invalid and Valid Cases)
        // ===============================
        System.out.println("\n===== STARTING WITHDRAWAL TESTS =====\n");

        double balanceBeforeWithdraw = bank.getAccount(savings1).getBalance();

        TransactionRequest withdrawInvalidAccount = bank.getUser(1).createTransactionRequest(new int[]{9999}, 1000, 1); // Should fail
        TransactionRequest withdrawUnauthorizedAccount = bank.getUser(2).createTransactionRequest(new int[]{savings1}, 1000, 1); // Should fail
        TransactionRequest validWithdrawSavings1 = bank.getUser(1).createTransactionRequest(new int[]{savings1}, 2000, 1); // Should succeed

        bank.processTransaction(withdrawInvalidAccount);
        bank.processTransaction(withdrawUnauthorizedAccount);
        bank.processTransaction(validWithdrawSavings1);

        double balanceAfterWithdraw = bank.getAccount(savings1).getBalance();

        System.out.println("User 1 Savings Balance before withdrawal attempts: " + balanceBeforeWithdraw);
        System.out.println("User 1 Savings Balance after withdrawal attempts: " + balanceAfterWithdraw);
        System.out.println("Expected difference (valid withdrawal only): -2000. Actual difference: " + (balanceBeforeWithdraw - balanceAfterWithdraw));

        System.out.println("User 2 Savings Balance after withdrawal attempts: " + bank.getAccount(savings2).getBalance());

        // ===============================
        // TRANSFER TESTS (Invalid and Valid Cases)
        // ===============================
        System.out.println("\n===== STARTING TRANSFER TESTS =====\n");

        TransactionRequest transferInvalidToAccount = bank.getUser(1).createTransactionRequest(new int[]{savings1, 9999}, 1000, 2); // Should fail
        TransactionRequest transferInvalidFromAccountBank = bank.getUser(1).createTransactionRequest(new int[]{9999, savings2}, 1000, 2); // Should fail
        TransactionRequest transferInvalidFromAccountUser = bank.getUser(2).createTransactionRequest(new int[]{savings1, savings2}, 1000, 2); // Should fail
        TransactionRequest validTransfer = bank.getUser(1).createTransactionRequest(new int[]{savings1, checking1}, 1500, 2); // Should succeed

        bank.processTransaction(transferInvalidToAccount);
        bank.processTransaction(transferInvalidFromAccountBank);
        bank.processTransaction(transferInvalidFromAccountUser);
        bank.processTransaction(validTransfer);

        System.out.println("User 1 Savings Balance after transfer attempts: " + bank.getAccount(savings1).getBalance());
        System.out.println("User 1 Checking Balance after transfer attempts: " + bank.getAccount(checking1).getBalance());
        System.out.println("User 2 Savings Balance after transfer attempts: " + bank.getAccount(savings2).getBalance());

        // ===============================
        // INVALID AMOUNT TESTS
        // ===============================
        System.out.println("\n===== STARTING INVALID AMOUNT TESTS =====\n");

        TransactionRequest negativeDeposit = bank.getUser(1).createTransactionRequest(new int[]{savings1}, -500, 0); // Should fail
        TransactionRequest negativeWithdrawal = bank.getUser(1).createTransactionRequest(new int[]{savings1}, -500, 1); // Should fail
        TransactionRequest negativeTransfer = bank.getUser(1).createTransactionRequest(new int[]{savings1, checking1}, -1000, 2); // Should fail

        bank.processTransaction(negativeDeposit);
        bank.processTransaction(negativeWithdrawal);
        bank.processTransaction(negativeTransfer);

        System.out.println("User 1 Savings Balance after invalid amount attempts: " + bank.getAccount(savings1).getBalance());
        System.out.println("User 1 Checking Balance after invalid amount attempts: " + bank.getAccount(checking1).getBalance());
    }
}