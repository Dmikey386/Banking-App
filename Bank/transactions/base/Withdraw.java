package bank.transactions.base;
import bank.account.BankAccount;
import bank.user.User;
import java.io.IOException;

public class Withdraw extends Transaction {
    private static final String type = "Withdraw";

    public Withdraw(int amount, String accountID) {
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
            withdrawFrom();
        }
        logTransaction();

    }


    public void withdrawFrom() throws IOException {
        BankAccount account = accountLog.getAccount(getAccountID());
        account.setBalance(account.getBalance() - getAmount());
        accountLog.logAccount(account);
        User user = userLog.getUser(account.getUserID());
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



