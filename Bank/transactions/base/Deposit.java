package bank.transactions.base;
import bank.account.*;
import bank.user.*;

import java.io.IOException;


public class Deposit extends Transaction {
    private static final String type = "Deposit";

    public Deposit(String transactionID,double amount, String accountID) {
        super(transactionID,amount, accountID);
    }

    @Override
    public String getType() {
        return type;
    }

    public void process() throws IOException {
        // update account and user logs with new balance
        BankAccount account = accountLog.getAccount(getAccountID());
        account.setBalance(account.getBalance() + getAmount());
        accountLog.logAccount(account);
        User user = userLog.getUser(account.getUserID());
        user.addAccount(account);
        userLog.logUser(user);
    }
}
