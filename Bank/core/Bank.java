package Bank.core;
import Bank.account.BankAccount;
import Bank.account.TransactionManager;
import Bank.account.User;

import java.util.HashMap;
import java.util.ArrayList;


public class Bank {
    private double monetaryBase;
    private HashMap<Integer, User> users;
    private HashMap<Integer, BankAccount> accounts = new HashMap<>();
    private TransactionManager transactionManager;



}
