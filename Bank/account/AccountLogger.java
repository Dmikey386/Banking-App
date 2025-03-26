package Bank.account;

import Bank.jsonStorage.JsonLogger;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class AccountLogger extends JsonLogger<BankAccount> {

    // constructor
    public AccountLogger() {
        super("Storage/accounts.json");
    }

    public void logAccount(String accountID, BankAccount account) throws IOException {
        logObject(accountID,account);
    }

    // get User from user log
    public BankAccount getAccount(String accountID) throws IOException {
        Map<String, Object> accountAttrMap = (Map<String, Object>) getObjectMap(accountID);
        String id = (String) accountAttrMap.get("accountID");
        Double balance = (Double) accountAttrMap.get("balance");
        BankAccount account = new BankAccount(id,balance);
        return account;

    }

    public boolean searchAccount(String accountID) throws IOException {
        HashMap accountLog = readLog();
        return accountLog.containsKey(accountID);
    }



}
