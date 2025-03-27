package Bank.automaticTransactions;

import Bank.core.Bank;
import Bank.singleTransactions.Withdraw;
import java.io.IOException;

public class AutoPayment extends AutoTransaction {

    public AutoPayment(String[] accountIDs, String rate, double amount) {
        super(accountIDs, rate, amount);
    }
    @Override
    public void process() throws IOException {
    }
}
