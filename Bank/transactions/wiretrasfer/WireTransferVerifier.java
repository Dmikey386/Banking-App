package bank.transactions.wiretrasfer;

import bank.account.AccountLogger;
import bank.account.BankAccount;
import bank.transactions.base.*;
import bank.user.UserLogger;

import java.io.IOException;

public class WireTransferVerifier extends TransactionVerifier {
    private AccountLogger accountLog = AccountLogger.getInstance();
    private TransactionFactory transactionFactory = new TransactionFactory();

    public void verifyWireTransfer(WireTransfer request, Transaction withdraw,Transaction deposit) throws IOException {
        try {
            verifyDeposit(deposit);
            verifyWithdraw(withdraw,deposit);
            withdraw.setApproval(true);
            request.setApproval(true);
        } catch(TransactionException e){
            withdraw.setFailureReason(e.getMessage());
            request.setFailureReason(e.getMessage());
        }
    }

    public void verifyDeposit(Transaction deposit) throws IOException, TransactionException {
        verifyTransaction(deposit);
    }
    public void verifyWithdrawAccount(Transaction withdraw) throws IOException, TransactionException {
        verifyFunds(withdraw);
        BankAccount withdrawalAccount = accountLog.getAccount(withdraw.getAccountID());
        verifySavingsAccount(withdrawalAccount);
    }
    public void verifyWithdraw(Transaction withdraw, Transaction deposit) throws IOException, TransactionException {
        verifyAccountID(withdraw);
        verifyAccountID(deposit);
        BankAccount withdrawAccount  = accountLog.getAccount(withdraw.getAccountID());
        BankAccount depositAccount = accountLog.getAccount(deposit.getAccountID());
        if (withdrawAccount.getUserID().equals(depositAccount.getUserID())) {
            verifyWithdrawAccount(withdraw);
            System.out.println("Fraud bypassed, shared userID");
        }
        else{
            verifyWithdrawAccount(withdraw);
            // add fraud verification
        }


    }



}
