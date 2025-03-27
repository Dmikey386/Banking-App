package Bank.automaticTransactions;

import Bank.core.Bank;
import Bank.singleTransactions.WireTransfer;

import java.io.IOException;

public class AutoWireTransfer extends AutoTransaction{
    // automatic wire transfer

    public AutoWireTransfer(Bank bank, String rate, String[] accountIDs, double amount) {
        super(bank, rate, accountIDs, amount);
    }

    @Override
    public void process() throws IOException {

    }
}
