package Bank.transactions.transactionProcessing.automatic;

import Bank.transactions.automaticTransactions.*;


public class AutoTransactionFactory {
    public static AutoTransaction createAutoTransaction(AutoTransactionRequest autoTransactionRequest)  {
        switch (autoTransactionRequest.getTransactionType()) {
            case 0: return new AutoPayment(autoTransactionRequest);
            case 1: return new AutoWireTransfer(autoTransactionRequest);
            default: throw new IllegalArgumentException("Invalid Transaction Type");
        }
    }
}
