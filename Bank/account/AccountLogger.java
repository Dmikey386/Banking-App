package Bank.account;

import Bank.JsonStorage.JsonLogger;
import java.io.IOException;


public class AccountLogger extends JsonLogger<BankAccount> {

    // constructor
    public AccountLogger() {
        super("Storage/accounts.json");
    }

    public void logAccount(String accountID, BankAccount account) throws IOException {
        logObject(accountID,account);
    }


}
