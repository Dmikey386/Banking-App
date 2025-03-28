package Bank.account;

import Bank.jsonStorage.JsonLogger;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class AccountLogger extends JsonLogger<BankAccount> {
    private static AccountLogger single_instance = new AccountLogger();

    // constructor
    public static AccountLogger getInstance() {
        if (single_instance == null) {
            single_instance = new AccountLogger();
        }
        return single_instance;
    }

    private AccountLogger() {
        super("Storage/accounts.json");
    }

    public void logAccount(BankAccount account) throws IOException {
        logObject(account.getAccountID(), account);
    }

    // get User from user log
    public BankAccount getAccount(String accountID) throws IOException {
        Map<String, Object> accountAttrMap = (Map<String, Object>) getObjectMap(accountID);
        String id = (String) accountAttrMap.get("accountID");
        String userId = (String) accountAttrMap.get("userID");
        Double balance = (Double) accountAttrMap.get("balance");
        BankAccount account = new BankAccount(id,userId,balance);
        return account;

    }

    public boolean searchAccount(String accountID) throws IOException {
        HashMap accountLog = readLog();
        return accountLog.containsKey(accountID);
    }



}
