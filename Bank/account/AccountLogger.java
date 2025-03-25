package Bank.account;

import java.util.HashMap;
import java.util.Map;

public class AccountLogger {
    private Map<String, BankAccount> accountLog = new HashMap<>();

    public void logAccount(String accountID, BankAccount account) {
        accountLog.put(accountID,account);
    }
    public BankAccount getAccount(String accountID) {
        return accountLog.get(accountID);
    }
    public boolean containsAccount(String accountID) {
        return accountLog.containsKey(accountID);
    }

}
