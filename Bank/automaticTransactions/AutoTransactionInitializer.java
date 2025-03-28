package Bank.automaticTransactions;

import Bank.IDTools.AutoTransactionIDGenerator;

import java.io.IOException;


public class AutoTransactionInitializer {
     private AutoTransactionVerifier verifier = new AutoTransactionVerifier();



    public void initializeAutoTransaction(AutoTransactionRequest autoTransactionRequest){

       // verifier.verifyTransaction();

    }

    // Create automatic transaction
    public AutoTransaction createAutoTransaction(AutoTransactionRequest autoTransactionRequest) {
        int type = autoTransactionRequest.getTransactionType();
        AutoTransaction transaction = null;
        String[] accountIDs = autoTransactionRequest.getAccountIDs();
        String rate = autoTransactionRequest.getRate();
        double amount = autoTransactionRequest.getAmount();

        switch (type) {
            case 0:
                transaction = new AutoDirectDeposit(accountIDs, rate, amount);
                break;
            case 1:
                transaction = new AutoPayment(accountIDs, rate, amount);
                break;
            case 2:
                transaction = new AutoWireTransfer(accountIDs, rate, amount);
                break;
            default:
                System.out.println("Invalid transaction type");

        }
        return transaction;
    }

}


