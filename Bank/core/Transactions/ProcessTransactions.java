package Bank.core.Transactions;


import Bank.account.Transaction;
import Bank.account.User;

public class ProcessTransactions<T> {
    private Transaction transaction;
    private User user;

    // Constructor
    public ProcessTransactions(Transaction transaction) {
        this.transaction = transaction;
    }

    // check for valid transaction
    // validate Users bank account withdrawal/transfer/deposit
    // validate if recipient account is valid if transfer

    // minium amounts
    // what account restrictions

    // Send transaction
    public void processTransaction(){


    }
}
