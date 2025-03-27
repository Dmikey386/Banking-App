package Bank.automaticTransactions;

import Bank.IDTools.AutoTransactionIDGenerator;
import Bank.account.AccountLogger;
import Bank.core.Bank;
import Bank.user.UserLogger;

public class AutoTransactionInitializer {
     private Bank bank;
     private AutoTransactionVerifier verifier = new AutoTransactionVerifier();
     private AutoTransactionIDGenerator idGenerator = new AutoTransactionIDGenerator();


    public void initializeAutoTransaction(AutoTransaction autoTransaction) {
        String AutoTrID = idGenerator.generateID();
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

class AutoTransactionVerifier{
    private UserLogger userLogger = new UserLogger();
    private AccountLogger accountLogger = new AccountLogger();


    public boolean verify(AutoTransactionRequest autoTransactionRequest) {
        return false;
    }
}

