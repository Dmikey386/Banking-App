package Bank.transactions.transactionProcessing.automatic;

import Bank.account.AccountLogger;
import Bank.user.UserLogger;

public class AutoTransactionVerifier{
    private UserLogger userLogger = UserLogger.getInstance();
    private AccountLogger accountLogger = AccountLogger.getInstance();

    public AutoTransactionRequest verifyTransaction(AutoTransactionRequest autoTransactionRequest){
        try {

        }
        catch (Exception e){
            autoTransactionRequest.setFailureReason(e.getMessage());
        }
        return autoTransactionRequest;
    }
}

class AutoTransactionException extends Exception{
    public AutoTransactionException(String message){
        super(message);
    }
}

