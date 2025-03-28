package Bank.transactions.transactionProcessing;

import Bank.transactions.automaticTransactions.*;
import Bank.transactions.transactionLoggers.AutoTransactionLogger;

import java.io.IOException;


public class AutoTransactionInitializer {
     private AutoTransactionVerifier verifier = new AutoTransactionVerifier();
     private AutoTransactionFactory factory = new AutoTransactionFactory();
     private AutoTransactionLogger logger = new AutoTransactionLogger();


    public void initializeAutoTransaction(AutoTransactionRequest autoTransactionRequest) throws IOException {
       verifier.verifyTransaction(autoTransactionRequest);
       if (!autoTransactionRequest.getVerification()){
           System.out.println(autoTransactionRequest.getFailureReason());
       }
       else{
           AutoTransaction transaction = factory.createAutoTransaction(autoTransactionRequest);
           logger.logAutoTransaction(transaction);
       }

    }

}


