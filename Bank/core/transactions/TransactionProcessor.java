package Bank.core.transactions;

import Bank.account.BankAccount;
import Bank.account.TransactionRequest;
import Bank.core.Bank;


public class TransactionProcessor {
    private TransactionVerifier transactionVerifier = new TransactionVerifier();
    private Bank bank;


    // constructor
    public TransactionProcessor(Bank bank) {
        this.bank = bank;
    }


    // Process the transaction
    public void processTransaction(TransactionRequest transactionRequest) {
        if (!transactionRequest.getStatus()){
            System.out.println("Transaction is not valid");
        }
        else{
            Transaction transaction = createTransaction(transactionRequest);
            transaction.process();

        }
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
