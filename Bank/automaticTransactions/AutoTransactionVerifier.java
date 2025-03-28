package Bank.automaticTransactions;

import Bank.account.AccountLogger;
import Bank.singleTransactions.TransactionVerifier;
import Bank.user.UserLogger;

import java.io.IOException;

public class AutoTransactionVerifier{
    private UserLogger userLogger = UserLogger.getInstance();
    private AccountLogger accountLogger = AccountLogger.getInstance();

    public boolean verifyTransaction(AutoTransactionRequest autoTransactionRequest){

        return false;
    }


}

