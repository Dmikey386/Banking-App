package Bank.core;

import Bank.account.TransactionRequest;
import Bank.account.User;

public class Main {
    public static void main(String[] args) {

        // process is slightly modified because bank does not store account or user data yet
        User user = new User(1);
        System.out.println(user);
        Bank bank = new Bank(user);
        int accSavingsID = user.openAccount("Savings");
        int accCheckingID = user.openAccount("Checking");


        TransactionRequest deposit = user.createTransactionRequest(new int[] {accSavingsID},10000,0);
        TransactionRequest withdraw = user.createTransactionRequest(new int[] {accSavingsID},5000,1);
        TransactionRequest transfer = user.createTransactionRequest(new int[] {accSavingsID,accCheckingID},2500,2);

        System.out.println(user.getAccount(accSavingsID).getBalance());
        System.out.println(accSavingsID);

        bank.processTransaction(deposit);


        System.out.println(user.getAccount(accSavingsID).getBalance());

        bank.processTransaction(withdraw);
        System.out.println(user.getAccount(accSavingsID).getBalance());
        System.out.println(user.getAccount(accCheckingID).getBalance());

        bank.processTransaction(transfer);
        System.out.println(user.getAccount(accSavingsID).getBalance());
        System.out.println(user.getAccount(accCheckingID).getBalance());

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
