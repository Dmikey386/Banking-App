package bank.transactions.automatic;

import bank.persistentstorage.AccountLogger;
import bank.persistentstorage.UserLogger;

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

