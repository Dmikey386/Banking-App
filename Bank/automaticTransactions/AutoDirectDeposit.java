package Bank.automaticTransactions;

import java.io.IOException;

public class AutoDirectDeposit extends AutoTransaction {


    public AutoDirectDeposit(String[] accountIDs, String rate, double amount) {
        super(accountIDs, rate, amount);
    }
    @Override
    public void process() throws IOException {

    }


}
