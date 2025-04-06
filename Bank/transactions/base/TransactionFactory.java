package bank.transactions.base;

import bank.idtools.TransactionIDGenerator;
import bank.idtools.UniqueIDGenerator;

public class TransactionFactory {
    private static final UniqueIDGenerator transactionIDGenerator = new TransactionIDGenerator();

    public static Transaction createTransaction(String type, String accountID, double amount) {
        String txnID = transactionIDGenerator.generateID();
        switch (type) {
            case "Deposit": return new Deposit(txnID,amount,accountID);
            case "Withdraw": return new Withdraw(txnID,amount,accountID);
            default: throw new IllegalArgumentException("Invalid Transaction type");
        }
    }
}
