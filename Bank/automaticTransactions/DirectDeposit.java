package Bank.automaticTransactions;

import Bank.core.Bank;
import Bank.singleTransactions.Deposit;
import java.io.IOException;

public class DirectDeposit extends AutoTransaction {


    public DirectDeposit(Bank bank, String rate, String[] accountIDs, double amount) {
        super(bank, rate, accountIDs, amount);
    }
    @Override
    public void process() throws IOException {

    }


}
