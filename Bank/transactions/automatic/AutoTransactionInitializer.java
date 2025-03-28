package bank.transactions.automatic;

import bank.transactions.loggers.AutoTransactionLogger;
import bank.transactions.loggers.AutoTransactionRequestLogger;

import java.io.IOException;


public class AutoTransactionInitializer {
     private AutoTransactionVerifier verifier = new AutoTransactionVerifier();
     private AutoTransactionFactory factory = new AutoTransactionFactory();
     private AutoTransactionLogger autoTransactionLogger = AutoTransactionLogger.getInstance();
     private AutoTransactionRequestLogger autoTransactionRequestLogger = AutoTransactionRequestLogger.getInstance();


    public void initializeAutoTransaction(AutoTransactionRequest autoTransactionRequest) throws IOException {
       verifier.verifyTransaction(autoTransactionRequest);
       if (!autoTransactionRequest.getVerification()){
           System.out.println(autoTransactionRequest.getFailureReason());
       }
       else{
           AutoTransaction transaction = factory.createAutoTransaction(autoTransactionRequest);
           autoTransactionLogger.logAutoTransaction(transaction); // log to auto transactions file
       }
        autoTransactionRequestLogger.logAutoTransactionReqeust(autoTransactionRequest); // log the request to requests file

    }

}


