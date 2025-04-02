package bank.transactions.base;

public class TransactionVerifier {

    public synchronized void verifyTransaction(Transaction transaction) {
        //verify -> accounts, balances
        transaction.setApproval(true);

        // fails
        //transaction.setApproval(false);
        //transaction.setFailureReason("Failure Reason");
    }
}

class TransactionException extends Exception{
    TransactionException(String message) {
        super(message);
    }
}
