package bank.transactions.base;
import bank.account.*;
import bank.user.User;
import java.io.IOException;

public class Withdraw extends Transaction {
    private static final String type = "Withdraw";

    public Withdraw(String txnID,double amount, String accountID) {
        super(txnID, amount, accountID);
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void process() throws IOException {
        BankAccount account = accountLog.getAccount(getAccountID());
        if (account instanceof SavingsAccount){
            ((SavingsAccount) account).incrementTxn();
        }
        if (account instanceof CheckingAccount){
            ((CheckingAccount) account).addToSpending(getAmount());
        }
        account.setBalance(account.getBalance() - getAmount());
        accountLog.logAccount(account);
        User user = userLog.getUser(account.getUserID());
        user.addAccount(account);
        userLog.logUser(user);
        System.out.println("Thread: " + Thread.currentThread().getId() + " withdraw "+  account.getBalance());
    }

    @Override // process withdraw as transfer, where checking spending is not incremented
    public void processAsTransfer() throws IOException {
        BankAccount account = accountLog.getAccount(getAccountID());
        if (account instanceof SavingsAccount){
            ((SavingsAccount) account).incrementTxn();
        }
        account.setBalance(account.getBalance() - getAmount());
        accountLog.logAccount(account);
        User user = userLog.getUser(account.getUserID());
        user.addAccount(account);
        userLog.logUser(user);

    }
}



