package Bank.core.transactions;

import Bank.account.User;
import Bank.account.BankAccount;
import Bank.account.TransactionRequest;
import Bank.core.Bank;

import java.util.HashMap;

public class TransactionProcessor {
    private TransactionVerifier transactionVerifier = new TransactionVerifier();
    private Bank bank;

    public TransactionProcessor(Bank bank) {
        this.bank = bank;
    }

    public void processTransaction(TransactionRequest transactionRequest) {
        if (transactionRequest.getStatus()){
            System.out.println("Transaction is not valid");
        }
        else{

            // Create Transaction Process Transaction
            Transaction transaction = createTransaction(transactionRequest);
            transaction.process();

        }
    }

    // Select Transaction Type
    public Transaction createTransaction(TransactionRequest transactionRequest) {
        int type = transactionRequest.getTransactionType();
        Transaction transaction = null;
        BankAccount[] accounts = getAccounts(transactionRequest);
        double amount = transactionRequest.getAmount();

        switch (type){
            case 0:
                transaction = new Deposit(accounts,amount);
                break;
                case 1:
                    transaction = new Withdraw(accounts,amount);
                    break;
                    case 2:
                        transaction = new WireTransfer(accounts,amount);
                        break;
                        default:
                            System.out.println("Invalid transaction type");

        }
        return transaction;

    }

    // Convert accounts to list of
    public BankAccount[] getAccounts(TransactionRequest transactionRequest) {
        int[] accountIDs = transactionRequest.getAccountIDs();
        BankAccount[] accounts = new BankAccount[accountIDs.length];

        for (int i = 0; i < accountIDs.length; i++){
            accounts[i] = bank.getAccount(accountIDs[i]);
        }
        return accounts;
    }


}
