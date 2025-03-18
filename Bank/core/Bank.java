package Bank.core;
import Bank.account.BankAccount;
import Bank.account.TransactionManager;
import Bank.account.TransactionRequest;
import Bank.account.User;
import Bank.core.transactions.TransactionProcessor;

import java.util.HashMap;
import java.util.ArrayList;


public class Bank {
    private double monetaryBase;
    private HashMap<Integer, User> users;
    private HashMap<Integer, BankAccount> accounts = new HashMap<>();
    private User user;
    private TransactionProcessor transactionProcessor;

    // bank is modified, because accounts are only stored in user data
    public Bank(User user) {
        this.user = user;
        transactionProcessor = new TransactionProcessor(this.user);
    }

    public BankAccount getAccount (int accountID){
        return accounts.get(accountID);
    }

    public void processTransaction(TransactionRequest request){
        transactionProcessor.processTransaction(request);
    }


}
