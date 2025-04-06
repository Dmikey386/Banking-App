package bank.account;

import bank.persistentstorage.JsonLogger;
import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
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
        String type = (String) accountAttrMap.get("type");
        Boolean frozen = (Boolean) accountAttrMap.get("frozen");

        if (type.equals("Checking")) {
            CheckingAccount account = new CheckingAccount(id,userId);
            account.setBalance(balance);
            account.setFrozen(frozen);
            account.setMonthlyLimit((Double) accountAttrMap.get("monthlyLimit"));
            account.setDailyLimit((Double) accountAttrMap.get("dailyLimit"));
            account.setMonthSpending((Double) accountAttrMap.get("monthSpending"));
            account.setDaySpending((Double) accountAttrMap.get("daySpending"));
            account.setLastDayReseet((LocalDate) accountAttrMap.get("lastDayReset"));
            account.setLastMonthReset((YearMonth) accountAttrMap.get("lastMonthReset"));
            return account;
        }
        else {
            SavingsAccount account = new SavingsAccount(id,userId);
            account.setBalance(balance);
            account.setFrozen(frozen);
            account.setLastMonthReset((YearMonth) accountAttrMap.get("lastMonthReset"));
            account.setNumTxnLimit((Integer) accountAttrMap.get("monthTxnLimit"));
            account.setMonthTxn((Integer) accountAttrMap.get("monthTxn"));
            return account;
        }
    }

    public boolean searchAccount(String accountID) throws IOException {
        HashMap accountLog = readLog();
        return accountLog.containsKey(accountID);
    }



}
