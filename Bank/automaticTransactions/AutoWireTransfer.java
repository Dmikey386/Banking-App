package Bank.automaticTransactions;

import Bank.core.Bank;
import Bank.singleTransactions.WireTransfer;

import java.io.IOException;

public class AutoWireTransfer extends AutoTransaction{
    // automatic wire transfer

    public AutoWireTransfer( String[] accountIDs, String rate, double amount) {
        super(accountIDs, rate, amount);
    }

    @Override
    public void process() throws IOException {

    }
}
