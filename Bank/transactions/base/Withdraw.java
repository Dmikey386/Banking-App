package bank.transactions.base;
import bank.account.*;
import bank.user.User;
import java.io.IOException;

public class Withdraw extends Transaction {
    private static final String type = "Withdraw";

    public Withdraw(String transactionID,double amount, String accountID) {
        super(transactionID, amount, accountID);
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void process() throws IOException {
        BankAccount account = accountLog.getAccount(getAccountID());
        if (account instanceof CheckingAccount){
            ((CheckingAccount) account).addToSpending(getAmount());
        }
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



