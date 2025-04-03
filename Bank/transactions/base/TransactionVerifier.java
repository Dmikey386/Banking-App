package bank.transactions.base;

import bank.account.AccountLogger;
import bank.account.BankAccount;
import java.io.IOException;
import java.util.Objects;

public class TransactionVerifier {
    private AccountLogger accountLog = AccountLogger.getInstance();

    public synchronized void verifyTransaction(Transaction transaction) throws IOException {
        try{
            verifyAccountID(transaction);
            verifyFunds(transaction);
            verifyAccountRestrictions(transaction);
            transaction.setApproval(true);
        }
        catch(TransactionException e){
            transaction.setFailureReason(e.getMessage());
        }
    }

    // Verify if the AccountID is valid
    public void verifyAccountID(Transaction transaction) throws TransactionException, IOException {
        if (!accountLog.searchAccount(transaction.getAccountID())){
            throw new TransactionException("Invalid " + transaction.getType() + " accountID: " + transaction.getAccountID());
        }
    }

    // Verify if the Account has sufficient funds if Withdrawing
    public void verifyFunds(Transaction transaction) throws TransactionException, IOException {
        if(Objects.equals(transaction.getType(), "Withdraw")){
            BankAccount account = accountLog.getAccount(transaction.getAccountID());
            if(transaction.getAmount() > account.getBalance()){
                throw new TransactionException("Insufficient funds: " + transaction.getAmount());
            }
        }
    }
    public void verifyAccountRestrictions(Transaction transaction) throws TransactionException, IOException {
        BankAccount account = accountLog.getAccount(transaction.getAccountID());
        if(account.isFrozen()){
            throw new TransactionException("Account is frozen. AccountID: " + transaction.getAccountID());
        }
        // verify account tx limits
    }

    public void fraudDetection(){
        // Implement later
    }
}



class TransactionException extends Exception{
    TransactionException(String message) {
        super(message);
    }
}
