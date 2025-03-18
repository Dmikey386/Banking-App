package Bank.core.transactions;

import java.util.HashMap;
import Bank.account.BankAccount;
import Bank.account.TransactionRequest;
import Bank.account.User;
import Bank.core.Bank;

public class TransactionVerifier {
    private Bank bank;
    private TransactionRequest transactionRequest;
    private int[] bankAccountIDs;
    private int transactionType;
    private double amount;
    private User user;
    private HashMap<Integer,BankAccount> accountBankMap;
    private HashMap<Integer,User> userBankMap;

    public TransactionVerifier(Bank bank, TransactionRequest transactionRequest) {
        // get transaction Request information
        this.transactionRequest = transactionRequest;
        bankAccountIDs = transactionRequest.getAccountIDs();
        transactionType = transactionRequest.getTransactionType();
        amount = transactionRequest.getAmount();
        user = transactionRequest.getUser();

        // get bank information
        this.bank = bank;
        accountBankMap = bank.getAccountsHashMap();
        userBankMap = bank.getUsersHashMap();


    }

    public TransactionRequest verifyTransaction() {
        try {
            verifyAmmount();
            verifyTransactionAccounts(bankAccountIDs);
            verifyWithdrawBalances(bankAccountIDs);
            transactionRequest.setStatus(true);
        }
        catch (TransactionVerifierException e){
            transactionRequest.setFailureStatement(e.getMessage());
        }
            return transactionRequest;
    }
    public void verifyTransactionAccounts(int[] accountIDs) throws TransactionVerifierException{
        if (transactionType == 0){
            verifyDepositAccounts(accountIDs[0]);
        }
        else if (transactionType == 1){
            verifyWithdrawAccounts(accountIDs[0]);
        }
        if (transactionType == 2) {
            if (accountIDs.length < 2) {
                throw new TransactionVerifierException("Transfer requires both a withdraw and deposit account.");
            }
            verifyTransferAccounts(accountIDs);
        }


    }

    public void verifyDepositAccounts(int accountID) throws TransactionVerifierException {
        // verify if deposit account (recieving money) is in bank database
        if (!accountBankMap.containsKey(accountID)) {
            throw new TransactionVerifierException("Deposit Account: " + accountID + " not found");
        }
    }

    public void verifyWithdrawAccounts(int accountID) throws TransactionVerifierException {
        // verify if withdraw account (removing money) is in bank database
        if (!accountBankMap.containsKey(accountID)) {
            throw new TransactionVerifierException("Withdraw Failed --> Account: " + accountID + " not found");
        }
        // verify if user requesting withdrawal owns the withdrawal account
        if (!user.getUserAccMap().containsKey(accountID)) {
            throw new TransactionVerifierException("User Does not have permission to withdraw from Account: " + accountID);
        }

    }
    public void verifyTransferAccounts(int[] accountIDs) throws TransactionVerifierException {
        int withdrawAccountID = accountIDs[0];
        int depositAccountID = accountIDs[1];

        verifyWithdrawAccounts(withdrawAccountID);
        verifyDepositAccounts(depositAccountID);
    }
    public void verifyWithdrawBalances(int[] accountIDs) throws TransactionVerifierException {
        if (transactionType != 0){ // if not a deposit
            int accountID = accountIDs[0];
            BankAccount withdrawAccount = accountBankMap.get(accountID);
            if (withdrawAccount.getBalance() - amount < 50){ // min-account-balance: 50
                throw new TransactionVerifierException("Insufficient Balance");
            }
        }
    }
    public void verifyAmmount() throws TransactionVerifierException {
        if (amount < 0){
            throw new TransactionVerifierException("Invalid Amount: " + amount);
        }
    }
}

class TransactionVerifierException extends Exception{
    public TransactionVerifierException(String message){
        super(message);
    }
}
