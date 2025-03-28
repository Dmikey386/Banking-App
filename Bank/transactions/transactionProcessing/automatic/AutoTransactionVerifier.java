package Bank.transactions.transactionProcessing.automatic;

import Bank.account.AccountLogger;
import Bank.transactions.transactionProcessing.single.TransactionRequest;
import Bank.transactions.transactionProcessing.single.TransactionVerifierException;
import Bank.user.User;
import Bank.user.UserLogger;

import java.io.IOException;

public class AutoTransactionVerifier{
    private AutoTransactionRequest transactionRequest;
    private String userID;
    private String[] bankAccountIDs;
    private int transactionType;
    private double amount;
    private AccountLogger accuontLog = AccountLogger.getInstance();
    private UserLogger userLog = UserLogger.getInstance();

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

