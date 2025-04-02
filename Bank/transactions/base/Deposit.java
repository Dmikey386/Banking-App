package bank.transactions.base;
import bank.account.*;
import bank.user.*;

import java.io.IOException;


public class Deposit extends Transaction {
    private static final String type = "Deposit";

    public Deposit(int amount, String accountID) {
        super(amount, accountID);
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void process() throws IOException {
        verifyTransaction();
        if (this.getApproval()){
            depositTo();
        }
        logTransaction();
    }

    public void depositTo() throws IOException {
        // update account and user logs with new balance
        BankAccount account = accountLog.getAccount(getAccountID());
        account.setBalance(account.getBalance() + getAmount());
        accountLog.logAccount(account);
        User user = userLog.getUser(account.getUserID());
        user.addAccount(account);
        userLog.logUser(user);
    }

    @Override
    public void logTransaction() throws IOException {
        transactionLog.logTransaction(this);
    }

    @Override
    public void verifyTransaction() {
        verifier.verifyTransaction(this);
    }

}
