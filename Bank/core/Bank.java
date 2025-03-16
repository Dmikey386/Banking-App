package Bank.core;
import Bank.account.BankAccount;
import Bank.account.User;

import java.util.HashMap;
import java.util.ArrayList;


public class Bank {
    private double monetaryBase;

    // User ID, OBJ store
    private HashMap<Integer, User> users;
    // Account ID, OBJ store
    private HashMap<Integer, BankAccount> accounts = new HashMap<>();

}
