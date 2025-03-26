package Bank.account;

import Bank.JsonStorage.JsonLogger;
import Bank.user.User;

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
        String id = (String) accountAttrMap.get("userID");
        Double balance = (Double) accountAttrMap.get("balance");
        BankAccount account = new BankAccount(id);
        return account;

    }



}
