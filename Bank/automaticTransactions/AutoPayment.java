package Bank.automaticTransactions;

import Bank.core.Bank;
import Bank.singleTransactions.Transaction;

public class AutoPayment extends AutoTransaction {

    public AutoPayment(Bank bank, String rate, String[] accountIDs, double amount) {
        super(bank, rate, accountIDs, amount);
    }
}
