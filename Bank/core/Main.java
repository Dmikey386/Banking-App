package Bank.core;

import Bank.account.TransactionRequest;
import Bank.account.User;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        User user = new User(1);
        int accSavingsID = user.openAccount("Savings");
        int accCheckingID = user.openAccount("Checking");

        TransactionRequest request = user.createTransactionRequest(new int[] {accSavingsID},10000,0);

        // Currently, fully functioning, User class with Hashmap<accountNums, balances>, and ability to create accounts
        // Bank - no functions, but has instance data structues, Hashmap UserIDs to user objects, and account IDs to account objects.
        // these stores are temporary for testing functionality before implementing relational database


        // TRANSACTION CLASS questions
        // request transaction - user or account method?
        // store an instance of each transaction as transaction class attribute?
        // just have methods to request each type of transaction  and dont use a transaction class
        // i like the idea of a transaction class, because then i can just store the class in the transaction manager. Is this a good idea

        // Next steps - create transaction lifecycle at each level (Bank, User, Account, transaction verifier, transaction processor)
        // Allow user or account to request transaction class,
        // Use transaction verifier to see if transaction is valid
        // Use transaction processor -> perform transaction using Deposit, Withdraw, or Transfer
        // Add transaction manager method to store transaction data as attribute of
        // add transaction to t

    }
}
