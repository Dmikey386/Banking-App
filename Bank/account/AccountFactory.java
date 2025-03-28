package Bank.account;

import Bank.IDTools.AccountIDGenerator;
import Bank.IDTools.UniqueIDGenerator;

public class AccountFactory {
    private static final UniqueIDGenerator accountIDGenerator = new AccountIDGenerator();

    public static BankAccount createAccount(String accountType, String userID){
        String accountID = accountIDGenerator.generateID();
        // create new account

        switch (accountType) {
            case "Checking": return new CheckingAccount(accountID,userID);
            case "Savings": return new SavingsAccount(accountID,userID);
            default: throw new IllegalArgumentException("Invalid account type");
        }
    }
}
