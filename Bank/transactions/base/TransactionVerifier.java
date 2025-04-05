package bank.transactions.base;

import bank.account.*;
import java.io.IOException;
import java.util.Objects;

public class TransactionVerifier {
    private AccountLogger accountLog = AccountLogger.getInstance();

    public synchronized void verifyTransaction(Transaction txn) throws IOException {
        try{
            verifyAccountID(txn);
            verifyFunds(txn);
            verifyAccountRestrictions(txn);
            txn.setApproval(true);
        }
        catch(TransactionException e){
            txn.setFailureReason(e.getMessage());
        }
    }

    // Verify if the AccountID is valid
    public void verifyAccountID(Transaction txn) throws TransactionException, IOException {
        if (!accountLog.searchAccount(txn.getAccountID())){
            throw new TransactionException("Invalid " + txn.getType() + " accountID: " + txn.getAccountID());
        }
    }

    // Verify if the Account has sufficient funds if Withdrawing
    public void verifyFunds(Transaction txn) throws TransactionException, IOException {
        if(txn.getType().equals("Withdraw")){
            BankAccount account = accountLog.getAccount(txn.getAccountID());
            if(txn.getAmount() > account.getBalance()){
                throw new TransactionException("Insufficient funds: " + txn.getAmount());
            }
        }
    }

    // verify if txn passes restrictions on account
    public void verifyAccountRestrictions(Transaction txn) throws TransactionException, IOException {
        if (txn.getType().equals("Withdraw")){
            BankAccount account = accountLog.getAccount(txn.getAccountID());
            if(account.isFrozen()){
                throw new TransactionException("Account is frozen. AccountID: " + txn.getAccountID());
            }
            else {
                verifyCheckingAccount(txn, account);
                verifySavingsAccount(account);
            }

        }
    }

    // verify restrictions on checking account
    public void verifyCheckingAccount(Transaction txn, BankAccount account) throws TransactionException, IOException {
        if (account instanceof CheckingAccount){
            CheckingAccount checkingAccount = (CheckingAccount) account;
            if (checkingAccount.getDailyLimit() != -1 && checkingAccount.getDailyLimit() < checkingAccount.getDaySpending() + txn.getAmount()){
                throw new TransactionException("Checking Account has reached daily limit: " + checkingAccount.getDailyLimit());
            }
            if (checkingAccount.getMonthSpending() != -1 && checkingAccount.getMonthlyLimit() < checkingAccount.getMonthSpending() + txn.getAmount()){
                throw new TransactionException("Checking Account has reached monthly limit: " + checkingAccount.getMonthlyLimit());
            }
        }
    }

    // verify restrictions on savings account
    public void verifySavingsAccount(BankAccount account) throws TransactionException, IOException {
        if (account instanceof SavingsAccount){
            SavingsAccount savingsAccount = (SavingsAccount) account;
            if (savingsAccount.getMonthTxnLimit() != -1 && savingsAccount.getMonthTxnLimit() < savingsAccount.getMonthTxn() + 1){
                throw new TransactionException("Savings account reached monthly txn limit: " +
                        savingsAccount.getMonthTxn() + "/" + savingsAccount.getMonthTxnLimit());
            }
        }

    }

    public void fraudDetection(){
        // Implement later
    }
}




