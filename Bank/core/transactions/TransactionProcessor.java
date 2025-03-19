package Bank.core.transactions;

import Bank.account.BankAccount;
import Bank.account.TransactionRequest;
import Bank.core.Bank;
import java.util.Random;


public class TransactionProcessor {
    private Bank bank;


    // constructor
    public TransactionProcessor(Bank bank) {
        this.bank = bank;
    }


    // Verify transaction
    public void verifyTransaction(TransactionRequest transactionRequest) {
        TransactionVerifier verifier = new TransactionVerifier(bank, transactionRequest);
        verifier.verifyTransaction();
    }

    // Process the transaction
    public void processTransaction(TransactionRequest transactionRequest) {
        Random rand = new Random();
        String transactionID = String.valueOf(rand.nextInt(10000));
        transactionRequest.setTransactionID(transactionID);
        verifyTransaction(transactionRequest);
        if (!transactionRequest.getStatus()){
            System.out.println(transactionRequest.getFailureStatement());
        }
        else{
            Transaction transaction = createTransaction(transactionRequest);
            transaction.process();
        }
        bank.logTransaction(transactionID,transactionRequest);
    }

    // create the transaction
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

    // Convert accountIDs to account objects
    public BankAccount[] getAccounts(TransactionRequest transactionRequest) {
        int[] accountIDs = transactionRequest.getAccountIDs();
        BankAccount[] accounts = new BankAccount[accountIDs.length];

        for (int i = 0; i < accountIDs.length; i++){
            accounts[i] = bank.getAccount(accountIDs[i]);
        }
        return accounts;
    }


}
