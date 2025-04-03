package bank.transactions.base;

import bank.account.*;
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

    // verify if txn passes restrictions on account
    public void verifyAccountRestrictions(Transaction transaction) throws TransactionException, IOException {
        if (transaction.getType().equals("Withdraw")){
            BankAccount account = accountLog.getAccount(transaction.getAccountID());
            if(account.isFrozen()){
                throw new TransactionException("Account is frozen. AccountID: " + transaction.getAccountID());
            }
            if (account instanceof CheckingAccount){
                verifyCheckingAccount(transaction);
            }
            else if (account instanceof SavingsAccount){
                verifySavingsAccount(transaction);
            }
            else {
                throw new TransactionException("Unsupported account type for withdrawal restrictions.");
            }

        }
    }

    // verify restrictions on checking account
    public void verifyCheckingAccount(Transaction transaction) throws TransactionException, IOException {
        CheckingAccount checkingAccount = (CheckingAccount) accountLog.getAccount(transaction.getAccountID());
        if (checkingAccount.getDailyLimit() != -1 && checkingAccount.getDailyLimit() < checkingAccount.getDaySpending() + transaction.getAmount()){
            throw new TransactionException("Checking Account has reached daily limit: " + checkingAccount.getDailyLimit());
        }
        if (checkingAccount.getMonthSpending() != -1 && checkingAccount.getMonthlyLimit() < checkingAccount.getMonthSpending() + transaction.getAmount()){
            throw new TransactionException("Checking Account has reached monthly limit: " + checkingAccount.getMonthlyLimit());
        }
    }

    // verify restrictions on savings account
    public void verifySavingsAccount(Transaction transaction) throws TransactionException, IOException {
        SavingsAccount savingsAccount = (SavingsAccount) accountLog.getAccount(transaction.getAccountID());
        if (savingsAccount.getMonthTxnLimit() != -1 && savingsAccount.getMonthTxnLimit() < savingsAccount.getMonthTxn() + 1){
            throw new TransactionException("Savings account reached monthly transaction limit: " +
            savingsAccount.getMonthTxn() + "/" + savingsAccount.getMonthTxnLimit());
        }
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
