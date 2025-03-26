package Bank.transactions;

import java.util.HashMap;

import Bank.account.AccountLogger;
import Bank.account.BankAccount;
import Bank.user.User;
import Bank.core.Bank;
import Bank.user.UserLogger;

public class TransactionVerifier {
    private Bank bank;
    private TransactionRequest transactionRequest;
    private String[] bankAccountIDs;
    private int transactionType;
    private double amount;
    private String userID;
    private AccountLogger accountBankMap;
    private UserLogger userBankMap;


    // Constructor
    public TransactionVerifier(Bank bank, TransactionRequest transactionRequest) {
        // get transaction Request information
        this.transactionRequest = transactionRequest;
        bankAccountIDs = transactionRequest.getAccountIDs();
        transactionType = transactionRequest.getTransactionType();
        amount = transactionRequest.getAmount();
        userID = transactionRequest.getUserID();

        // get bank information
        this.bank = bank;
        //accountBankMap = bank.getAccountLog();
        //userBankMap = bank.getUsersHashMap();


    }


    // Verify a transaction
    public TransactionRequest verifyTransaction() {
        try {
            verifyAmmount();
            verifyTransactionAccounts();
            verifyWithdrawBalances();
            transactionRequest.setStatus(true);
        }
        catch (TransactionVerifierException e){
            transactionRequest.setFailureStatement(e.getMessage());
        }
            return transactionRequest;
    }

    // Verify all account parameters for a transaction
    public void verifyTransactionAccounts() throws TransactionVerifierException{
        if (transactionType == 0){
            verifyDepositAccounts(bankAccountIDs[0]);
        }
        else if (transactionType == 1){
            verifyWithdrawAccounts(bankAccountIDs[0]);
        }
        if (transactionType == 2) {
            if (bankAccountIDs.length < 2) {
                throw new TransactionVerifierException("Transfer requires both a withdraw and deposit account.");
            }
            verifyTransferAccounts(bankAccountIDs);
        }


    }

    // Verify if Deposit Accounts
    public void verifyDepositAccounts(String accountID) throws TransactionVerifierException {
//        // verify if deposit account (recieving money) is in bank database
//        if (!accountBankMap.containsAccount(accountID)) {
//            throw new TransactionVerifierException("Deposit Account: " + accountID + " not found");
//        }
    }

    // Verify Withdrawal Accounts
    public void verifyWithdrawAccounts(String accountID) throws TransactionVerifierException {
        // verify if withdraw account (removing money) is in bank database
//        if (!accountBankMap.containsAccount(accountID)) {
//            throw new TransactionVerifierException("Withdraw Failed --> Account: " + accountID + " not found");
//        }
//        // verify if user requesting withdrawal owns the withdrawal account
//        if (!user.getUserAccMap().containsKey(accountID)) {
//            throw new TransactionVerifierException("User Does not have permission to withdraw from Account: " + accountID);
//        }

    }
    // Verify Transfer accounts
    public void verifyTransferAccounts(String[] accountIDs) throws TransactionVerifierException {
        String withdrawAccountID = accountIDs[0];
        String depositAccountID = accountIDs[1];

        verifyWithdrawAccounts(withdrawAccountID);
        verifyDepositAccounts(depositAccountID);
    }

    // Verify valid balances
    public void verifyWithdrawBalances() throws TransactionVerifierException {
//        if (transactionType != 0){ // if not a deposit
//            String accountID = bankAccountIDs[0];
//            BankAccount withdrawAccount = accountBankMap.getAccount(accountID);
//            if (withdrawAccount.getBalance() - amount < 50){ // min-account-balance: 50
//                throw new TransactionVerifierException("Insufficient Balance");
//            }
//        }
    }
    // Verify amount in transaction is valid
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
